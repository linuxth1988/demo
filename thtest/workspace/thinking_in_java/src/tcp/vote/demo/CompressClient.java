package tcp.vote.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * WARNING: this code can deadlock if a large file(more than a few 10's of
 * thousands of bytes) is send
 * 
 * 程序从命令行中指定的文件读取未压缩字节,然后将压缩后的字节写入一个新的文件。
 * 设未压缩文件名是"data",压缩后文件名是"data.gz".
 */
public class CompressClient
{
	public static final int BUFSIZE = 256; // Size of read buffer

	public static void main(String[] args) throws IOException
	{
		if (args.length != 3)
			throw new IllegalArgumentException("Parameter(s): <Server> <Port> <file>");

		String server = args[0];// server name or IP
		int port = Integer.parseInt(args[1]);// server port
		String filename = args[2];// File to read data from

		// open input and output file (named input.gz)
		FileInputStream fileIn = new FileInputStream(filename);
		FileOutputStream fileOut = new FileOutputStream(filename + ".gz");

		// create socket conneted to server on specified port
		Socket socket = new Socket(server, port);

		// send uncompressed byte stream to server
		sendBytes(socket, fileIn);

		// receive compressed byte stream from server
		InputStream sockIn = socket.getInputStream();
		int bytesRead;// the number of bytes read
		byte[] buffer = new byte[BUFSIZE];

		while ((bytesRead = sockIn.read(buffer)) != -1)
		{
			fileOut.write(buffer, 0, bytesRead);
			System.out.println("R");// reading progress indicator
		}

		System.out.println();// End progress indicator line

		socket.close();// close the socket and its stream
		fileIn.close();
		fileOut.close();
	}

	private static void sendBytes(Socket socket, FileInputStream fileIn) throws IOException
	{
		OutputStream socketOut = socket.getOutputStream();
		int bytesRead;// Number of bytes read
		byte[] buffer = new byte[BUFSIZE];

		while ((bytesRead = fileIn.read(buffer)) != -1)
		{
			socketOut.write(buffer, 0, bytesRead);
			System.out.println("W");// writing progress indicator
		}
		
		System.out.println("sendBytes finished");

		socket.shutdownOutput();// finished sending
	}
}
