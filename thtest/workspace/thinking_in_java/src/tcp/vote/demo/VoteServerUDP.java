package tcp.vote.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class VoteServerUDP
{
	public static void main(String[] args) throws IOException
	{
		if (args.length != 1)
				throw new IllegalArgumentException("Parameter(): <Port>");

		int port = Integer.parseInt(args[0]);

		DatagramSocket serverSocket = new DatagramSocket(port);

		byte[] inBuffer = new byte[VoteMsgTextCoder.MAX_WIRE_LENGTH];
		// change bin to text for a different coding approach
		VoteMsgCoder coder = new VoteMsgTextCoder();
		VoteService service = new VoteService();

		while (true)
		{
			DatagramPacket packet = new DatagramPacket(inBuffer, inBuffer.length);
			serverSocket.receive(packet);

			byte[] encodedMsg = Arrays.copyOfRange(packet.getData(), 0, packet.getLength());
			System.out.println("Handling reuest from " + packet.getLength() + " bytes");

			try
			{
				VoteMsg msg = coder.fromWire(encodedMsg);
				msg = service.handleRequest(msg);
				packet.setData(coder.toWire(msg));

				System.out.println("Sending response ( " + packet.getLength() + "bytes");
				System.out.println(msg);
				serverSocket.send(packet);
			}
			catch (IOException ioe)
			{
				System.out.println("Parse error in message: " + ioe.getMessage());
			}
		}

	}
}
