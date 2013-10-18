package tcp.vote.demo;

import java.io.OutputStream;
import java.net.Socket;

public class VoteClientTCP
{
	public static final int CANDIDATEID = 999;

	public static void main(String[] args) throws Exception
	{
		if (args.length != 2)
			throw new IllegalArgumentException("Parameter(s) <Server> <Port>");

		String destAddr = args[0];
		int destPort = Integer.parseInt(args[1]);

		Socket socket = new Socket(destAddr, destPort);
		OutputStream out = socket.getOutputStream();

		// change Bin to Text for a diffrent framing strategy
		VoteMsgCoder coder = new VoteMsgBinCoder();

		// Change length to Delim for a different encoding strategy
		Framer framer = new LengthFramer(socket.getInputStream());
//		Framer framer = new DelimFramer(socket.getInputStream());

		// Create an inquiry request (2nd arg=true)
		VoteMsg msg = new VoteMsg(false, true, CANDIDATEID, 0);

		byte[] encodedMsg = coder.toWire(msg);

		// send request
		System.out.println("Sending Inquiry (" + encodedMsg.length + " bytes:");

		framer.frameMsg(encodedMsg, out);

		// receive vote response
		msg = coder.fromWire(encodedMsg);
		System.out.println(" Received Response (" + encodedMsg.length + " bytes): ");

		System.out.println(msg);

		socket.close();

	}
}
