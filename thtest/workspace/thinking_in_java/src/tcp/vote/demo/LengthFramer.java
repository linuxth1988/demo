package tcp.vote.demo;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LengthFramer implements Framer
{
	public static final int MAXMESSAGELENGTH=65535;
	public static final int BYTEMASK = 0xff;//255
	public static final int SHORTMASK= 0xffff;
	public static final int BYTESHIFT=8;
	
	private DataInputStream datainput;//wrapper for data I/0
	
	public LengthFramer(InputStream in)throws IOException
	{
		this.datainput = new DataInputStream(in);
	}

	@Override
	public void frameMsg(byte[] message, OutputStream out) throws IOException
	{
		if(message.length > MAXMESSAGELENGTH)
			throw new IOException("message too long");
		
		//write length prefix
		out.write((message.length >> BYTESHIFT) & BYTEMASK); 
		out.write(message.length & BYTEMASK);
		
		//write message
		out.write(message);
		out.flush();
	}

	@Override
	public byte[] nextMsg() throws IOException
	{
		int length;
		try
		{
			length = datainput.readUnsignedShort();//read 2 bytes
		}
		catch(EOFException e)
		{
			//no (or 1 byte)message
			return null;
		}
		
		//0 <= length <= 65535
		byte[] msg = new byte[length];
		datainput.readFully(msg);//if exception, it's a framing error
		
		return msg;
	}
}
