package tcp.vote.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class VoteServerTCP
{
	public static void main(String[] args) throws Exception
	{
		if (args.length != 1)
			throw new IllegalArgumentException("Parameter(s): <Port>");

		int port = Integer.parseInt(args[0]);

		ServerSocket servSocket = new ServerSocket(port);

		// Change Bin to Text on both client and server for different encoding
		VoteMsgCoder coder = new VoteMsgBinCoder();
		VoteService service = new VoteService();

		while (true)
		{
			Socket acceptSocket = servSocket.accept();
			System.out.println("Handling client at: " + acceptSocket.getRemoteSocketAddress());

			// change length to delim for a different framing strategy
			Framer framer = new LengthFramer(acceptSocket.getInputStream());

			try
			{
				byte[] req;
				while ((req = framer.nextMsg()) != null)
				{
					System.out.println("Received message (" + req.length + " bytes");
					VoteMsg responseMsg = service.handleRequest(coder.fromWire(req));
					framer.frameMsg(coder.toWire(responseMsg), acceptSocket.getOutputStream());
				}
			}
			catch (IOException e)
			{
				System.out.println("Error handling client: " + e.getMessage());
			}
			finally
			{
				System.out.println("Closing connection");
				acceptSocket.close();
			}
		}
	}
}
