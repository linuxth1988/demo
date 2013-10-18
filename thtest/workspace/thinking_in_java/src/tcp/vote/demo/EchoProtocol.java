package tcp.vote.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoProtocol implements Runnable
{
	private static final int BUFSIZE = 32;// size (in bytes) of I/0 buffer

	private Socket clntSocket;// Socket connect to client
	private Logger logger;// Server logger

	public EchoProtocol(Socket clntSocket, Logger logger)
	{
		this.clntSocket = clntSocket;
		this.logger = logger;
	}

	public static void handleEchoClient(Socket clntSocket, Logger logger)
	{
		try
		{
			// Get the input and output I/0 received message
			InputStream in = clntSocket.getInputStream();
			OutputStream out = clntSocket.getOutputStream();

			int recvMsgSize; // Size of received message
			int totalBytesEchoed = 0; // Bytes received from client
			byte[] echoBuffer = new byte[BUFSIZE];// receive buffer

			// Receive until client closes connection,indicated by -1
			while ((recvMsgSize = in.read(echoBuffer)) != -1)
			{
				out.write(echoBuffer, 0, recvMsgSize);
				totalBytesEchoed += recvMsgSize;
			}

			logger.info("Client " + clntSocket.getRemoteSocketAddress() + ":" + ",echoed " + totalBytesEchoed + " bytes.");

		}
		catch (IOException ioe)
		{
			logger.log(Level.WARNING, "Exception in echo protocol", ioe);
		}
		finally
		{
			try
			{
				clntSocket.close();
			}
			catch (IOException e)
			{
			}
		}
	}

	@Override
	public void run()
	{
		handleEchoClient(clntSocket, logger);
	}
}
