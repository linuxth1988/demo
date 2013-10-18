package tcp.vote.demo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 用文本方式对消息进行编码版本。 该协议制定使用US-ASCII字符集对文本进行编码。消息的开头是一个所谓的"魔术字符串"
 * 即一个字符序列,用于接收者快速将投票协议的消息和网络中随即到来的垃圾消息区分开来. 投票/查询布尔值被编码成字符形式 'v'表示投票 'i'表示查询信息。
 * 消息的状态即是否为服务器的响应,由字符'R'指示。 状态标记后面是候选人ID， 其后跟着的是选票总数,他们都被编码成十进制字符串
 * */
public class VoteMsgTextCoder implements VoteMsgCoder
{
	/**
	 * Wire Format "VOTEPROTO" <"v"|"i"> [<RESPFLAG>] <CANDIDATE>
	 * [<VOTECOUNT>] charset is fixed by the wire format
	 */
	// (inquiry|vote)  (response)  (candidateID)  (voteCount)

	// Manifest constants for encoding
	public static final String MAGIC = "Voting";
	public static final String VOTESTR = "v";
	public static final String INQSTR = "i";
	public static final String RESPONSESTR = "R";
	public static final String CHARSETNAME = "US-ASCII";
	public static final String DELIMSTR = " ";
	public static final int MAX_WIRE_LENGTH = 2000;

	@Override
	public byte[] toWire(VoteMsg msg) throws IOException
	{
		String msgString = MAGIC + DELIMSTR + (msg.isInquiry() ? INQSTR : VOTESTR) + DELIMSTR
				+ (msg.isResponse() ? RESPONSESTR + DELIMSTR : "")
				+ Integer.toString(msg.getCandidateID()) + DELIMSTR + Long.toString(msg.getVoteCount());

		byte[] data = msgString.getBytes(CHARSETNAME);

		return data;
	}

	@Override
	public VoteMsg fromWire(byte[] message) throws IOException
	{
		ByteArrayInputStream msgStream = new ByteArrayInputStream(message);

		Scanner scanner = new Scanner(new InputStreamReader(msgStream, CHARSETNAME));

		boolean isInquiry;
		boolean isResponse;
		int candidateID;
		long voteCount;
		String token;

		try
		{
			token = scanner.next();
			if (!token.equals(MAGIC))
				throw new IOException("Bad magic String " + token);

			token = scanner.next();
			if (token.equals(VOTESTR))
				isInquiry = false;
			else if (!token.equals(INQSTR))
					throw new IOException("Bad vote/inq indicator: " + token);
			else
				isInquiry = true;

			token = scanner.next();
			if (token.equals(RESPONSESTR))
			{
				isResponse = true;
				token = scanner.next();
			}
			else
				isResponse = false;

			// Current token is candidateID
			// Note: isResponse now valid
			candidateID = Integer.parseInt(token);
			if (isResponse)
				voteCount = Long.parseLong(token);
			else
				voteCount = 0;
		}
		catch (IOException e)
		{
			throw new IOException("Parse error...");
		}

		return new VoteMsg(isResponse, isInquiry, candidateID, voteCount);
	}
}
