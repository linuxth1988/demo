package tcp.vote.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * demonstrate另一种对投票协议消息进行编码的方法。 与基于文本的格式相反,二进制格使用固定大小的消息.
 * 每条消息由一个特殊字节开始,该字节的最高六位为一个"魔术"值010101. 这一点冗余的信息为接收者收到适当的投票消息提供了一定程度的保证.
 * 该字节的最低两位对两个布尔值进行编码.消息的第二个字节总是0，
 * 第三,第四个字节包含了candidateID值,只有响应消息的最后8个字节才包含了选票总数信息.
 */
public class VoteMsgBinCoder implements VoteMsgCoder
{
	// manifest constants for encoding
	public static final int MIN_WIRE_LENGTH = 4;
	public static final int MAX_WIRE_LENGTH = 16;
	public static final int MAGIC = 0x5400;
	public static final int MAGIC_MASK = 0xfc00;
	public static final int MAGIC_SHIFT = 8;
	public static final int RESPONSE_FLAG = 0x0200;
	public static final int INQUIRE_FLAG = 0x0100;//256

	// (inquiry|vote) (response) (candidateID) (voteCount)

	/**
	 * 这个编码方法利用了在合法 candidateID 中,其最高两个字节始终为 0 的特点。 
	 * 还要注意的是,该方法通过使用按位或操作,使用 1位对每个布尔值进行编码
	 */

	@Override
	public byte[] toWire(VoteMsg msg) throws IOException
	{
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		// converts ints
		DataOutputStream out = new DataOutputStream(byteStream);

		short magicAndFlags = MAGIC;//21504

		System.err.println("magicAndFlags = " + magicAndFlags);
		
		if (msg.isInquiry())
			magicAndFlags |= INQUIRE_FLAG;//21760

		System.err.println("magicAndFlags |= INQUIRE_FLAG = " + magicAndFlags);
		
		
		if (msg.isResponse())
			magicAndFlags |= RESPONSE_FLAG;
		
		System.err.println("magicAndFlags |= RESPONSE_FLAG= " + magicAndFlags);

		out.writeShort(magicAndFlags);

		// we know the candidate ID will fit in a short: it's > 0 && <1000
		out.writeShort((short) msg.getCandidateID());

		if (msg.isResponse())
			out.writeLong(msg.getVoteCount());

		out.flush();

		byte[] data = byteStream.toByteArray();

		return data;
	}

	@Override
	public VoteMsg fromWire(byte[] input) throws IOException
	{
		// sanity checks
		if (input.length < MIN_WIRE_LENGTH)
			throw new IOException("Runt message");

		ByteArrayInputStream bs = new ByteArrayInputStream(input);
		DataInputStream in = new DataInputStream(bs);

		int magic = in.readShort();

		if ((magic & MAGIC_MASK) != MAGIC)
				throw new IOException("Bad Magic #:" + ((magic & MAGIC_MASK) >> MAGIC_SHIFT));

		boolean resp = ((magic & RESPONSE_FLAG) != 0);
		boolean inq = ((magic & INQUIRE_FLAG) != 0);
		int candidateID = in.readShort();

		if (candidateID < 0 || candidateID > 1000)
				throw new IOException("Bad candidateID: " + candidateID);

		long count = 0;

		if (resp)
			count = in.readLong();

		if (count < 0)
				throw new IOException("Bad vote count: " + count);

		// Ignore any extra bytes
		return new VoteMsg(resp, inq, candidateID, count);
	}
}
