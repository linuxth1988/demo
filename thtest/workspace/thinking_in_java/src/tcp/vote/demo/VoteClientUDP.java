package tcp.vote.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/**
 * UDP版本的投票客户端与TCP版本非常相似.需要注意的是在UDP客户端中我们不需要使用成帧器。
 * 因为UDP协议位我们维护了消息的边界信息。对于UDP协议,我们使用给予文本的编码方式对消息进行编码
 */
public class VoteClientUDP
{
	public static void main(String[] args) throws IOException
	{
		if (args.length != 3)
			throw new IllegalArgumentException("Parameter(s): " + "<Destination> " + "<Port> " + " <Candidate>");

		// Destination addr
		InetAddress destAddr = InetAddress.getByName(args[0]);
		// Destination port
		int destPort = Integer.parseInt(args[1]);

		int candidate = Integer.parseInt(args[2]);

		// the UDP socket for sending
		DatagramSocket socket = new DatagramSocket();
		socket.connect(destAddr, destPort);

		// Create a voting message(2nd param false=vote)
		VoteMsg vote = new VoteMsg(false, false, candidate, 0);

		// change text to bin here for a different coding strategy
		VoteMsgCoder coder = new VoteMsgTextCoder();

		// send request
		byte[] encodedVote = coder.toWire(vote);
		System.out.println("Sending Text-Encoded Request (" + encodedVote.length + " bytes");
		System.out.println(vote);

		DatagramPacket packet = new DatagramPacket(encodedVote, encodedVote.length);
		socket.send(packet);

		// receive response
		DatagramPacket receivePacket = new DatagramPacket(new byte[VoteMsgTextCoder.MAX_WIRE_LENGTH],
				VoteMsgTextCoder.MAX_WIRE_LENGTH);
		socket.receive(receivePacket);

		encodedVote = Arrays.copyOfRange(receivePacket.getData(), 0, receivePacket.getLength());

		System.out.println("Received Text-Encoded Response (" + encodedVote.length + " bytes:)");
		vote = coder.fromWire(encodedVote);
		System.out.println(vote);

	}
}
