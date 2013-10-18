package tcp.vote.demo;

import java.util.HashMap;
import java.util.Map;

public class VoteService
{
	// Map of candidates to number of votes
	private Map<Integer, Long> results = new HashMap<Integer, Long>();

	public VoteMsg handleRequest(VoteMsg msg)
	{
		// If response, just send it back
		if (msg.isResponse())
			return msg;

		// Make message a response
		msg.setResponse(true);

		// Get candidate ID and vote count
		int candidate = msg.getCandidateID();
		Long count = results.get(candidate);

		// Candidate does not exist
		if (count == null)
				count = 0L;
		
		// If vote, increment count
		if (!msg.isInquiry())
			results.put(candidate, ++count);
		
		msg.setVoteCount(count);
		
		return msg;
	}
}
