package tcp.vote.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;

/**
 * 使用GZIP算法实现了服务器端的压缩协议. 服务器从客户端接收未压缩的字节并将其写入GZIPOuputStream 它对套接字的输出流进行了封装
 */
public class CompressProtocol implements Runnable
{
	public static final int BUFSIZE = 1024;

	private Socket clntSocket;
	private Logger logger;

	public CompressProtocol(Socket clntSocket, Logger logger)
	{
		this.clntSocket = clntSocket;
		this.logger = logger;
	}

	public static void handleCompressClient(Socket clntSocket, Logger logger)
	{
		try
		{
			// get the input and output stream from socket
			InputStream in = clntSocket.getInputStream();
			GZIPOutputStream out = new GZIPOutputStream(clntSocket.getOutputStream());

			byte[] buffer = new byte[BUFSIZE];// allocate read/write
									// buffer
			int byteRead;

			// Receive until client closes connection,indicated by -1
			// return
			while ((byteRead = in.read(buffer)) != -1)
			{
				out.write(buffer, 0, byteRead);
				out.finish();// Flush bytes from GZIPOutputStream
			}

			logger.info("Client" + clntSocket.getRemoteSocketAddress() + " finied");

		}
		catch (IOException ioe)
		{
			logger.log(Level.WARNING, "Exception in echo protocol", ioe);
		}

		try
		{
			clntSocket.close();
		}
		catch (IOException ioe)
		{
			logger.log(Level.WARNING, "Exception in close ", ioe.getMessage());
		}
	}

	public static void main(String[] args) throws IOException
	{
		if(args.length != 1)
			throw new IllegalArgumentException("Parameter(s): <Port>");
		
		int port = Integer.parseInt(args[0]);
		
		ServerSocket server = new ServerSocket(port);
		
		Socket clntSocket = server.accept();
		Logger logger = Logger.getLogger("hehe");
		
		CompressProtocol cp = new CompressProtocol(clntSocket, logger);
		new Thread(cp).start();
	}

	@Override
	public void run()
	{
		while(true)
		handleCompressClient(clntSocket, logger);
	}
}
