package tcp.vote.demo;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DelimFramer implements Framer
{
	private InputStream in;// data source
	private static final byte DELIMITER = '\n'; // message delimiter

	public DelimFramer(InputStream in)
	{
		this.in = in;
	}

	@Override
	public void frameMsg(byte[] message, OutputStream out) throws IOException
	{
		for (byte b : message)
		{
			if (b == DELIMITER)
					throw new IOException("Message can not contain delimiter");
		}
		out.write(message);
		out.write(DELIMITER);
		out.flush();
	}

	@Override
	public byte[] nextMsg() throws IOException
	{
		ByteArrayOutputStream messageBuffer = new ByteArrayOutputStream();
		int nextByte;

		// fetch bytes until find delimiter
		while ((nextByte = in.read()) != DELIMITER)
		{
			if (nextByte == -1)
			{
				if (messageBuffer.size() == 0)
						return null;
				else
						// if bytes followed by end of stream: framing error
						throw new EOFException("Non-empty message without delimiter");
			}
			
			// write byte to buffer
			messageBuffer.write(nextByte);
		}
		return messageBuffer.toByteArray();
	}
}
