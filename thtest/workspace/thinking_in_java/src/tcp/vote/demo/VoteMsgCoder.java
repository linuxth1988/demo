package tcp.vote.demo;

import java.io.IOException;

/**提供对投票信息进行序列化和反序列化的接口*/
public interface VoteMsgCoder
{
	byte[] toWire(VoteMsg msg)throws IOException;
	VoteMsg fromWire(byte[] message)throws IOException;
}
