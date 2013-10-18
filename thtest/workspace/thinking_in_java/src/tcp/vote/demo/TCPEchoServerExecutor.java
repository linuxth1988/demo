package tcp.vote.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class TCPEchoServerExecutor
{
	public static void main(String[] args) throws IOException
	{
		if (args.length != 1)
			throw new IllegalArgumentException("Parameter(s): <Port>");

		int echoServPort = Integer.parseInt(args[0]);

		// Create a server socket to accept client connection requests
		ServerSocket servSock = new ServerSocket(echoServPort);

		Logger logger = Logger.getLogger("practical");

		Executor service = Executors.newCachedThreadPool();

		// run forever accepting and spawning a thread for each connection

		while (true)
		{
			Socket clntSock = servSock.accept();
			service.execute(new EchoProtocol(clntSock, logger));
		}

	}
}
