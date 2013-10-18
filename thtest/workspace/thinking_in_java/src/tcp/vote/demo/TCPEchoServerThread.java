package tcp.vote.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class TCPEchoServerThread
{
	public static void main(String[] args) throws IOException
	{
		if (args.length != 1)
			throw new IllegalArgumentException("Parameter(s): <Port>");

		int echoServPort = Integer.parseInt(args[0]);

		// Create a server socket to accept client connection requests
		ServerSocket serverSocket = new ServerSocket(echoServPort);

		Logger logger = Logger.getLogger("practical");

		// Run forever,accepting and spawning a thread for each connection
		while (true)
		{
			// bolck waiting for connection
			Socket clntSocket = serverSocket.accept();

			// spawn thread to handle new connection
			Thread thread = new Thread(new EchoProtocol(clntSocket, logger));
			thread.start();
			logger.info("Create and started Thread " + thread.getName());
		}
	}
}
