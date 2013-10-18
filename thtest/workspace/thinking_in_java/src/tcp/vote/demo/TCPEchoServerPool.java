package tcp.vote.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPEchoServerPool
{
	public static void main(String[] args) throws IOException
	{
		if (args.length != 2)
			throw new IllegalArgumentException("Parameter(s) <Port> <Thread>");

		int echoServerPort = Integer.parseInt(args[0]);
		int threadPoolSize = Integer.parseInt(args[1]);

		// Create a server socket to accept client connection requersts
		final ServerSocket serverSocket = new ServerSocket(echoServerPort);

		final Logger logger = Logger.getLogger("practical");

		// spawn a fixed number of threads to service clients
		for (int i = 0; i < threadPoolSize; i++)
		{
			Thread thread = new Thread()
			{
				@Override
				public void run()
				{
					while (true)
					{
						try
						{
							// wait for a connection
							Socket clntSocket = serverSocket.accept();
							EchoProtocol.handleEchoClient(clntSocket, logger);
						}
						catch (IOException ioe)
						{
							logger.log(Level.WARNING, "Client accept failed", ioe);
						}
					}
				}
			};

			thread.start();
			logger.info("Created and started Thread = " + thread.getName());
		}
	}
}
