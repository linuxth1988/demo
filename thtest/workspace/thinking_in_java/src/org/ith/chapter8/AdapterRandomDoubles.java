package org.ith.chapter8;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class AdapterRandomDoubles extends RandomDoubles implements Readable
{
	private int count;
	
	public AdapterRandomDoubles(int count)
	{
		this.count = count;
	}
	
	
	@Override
	public int read(CharBuffer cb) throws IOException
	{
		if(count-- == 0)
			return -1;
		
		String result = Double.toString(next())+"  ";
		
		cb.append(result);
		
		return result.length();
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(new AdapterRandomDoubles(7));
		
		while(s.hasNext())
			System.out.println(s.next());
	}
}
