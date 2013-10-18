package org.ith.generic511;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer>
{
	private int n;

	public IterableFibonacci(int count)
	{
		n = count;
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new Iterator<Integer>()
		{
			public boolean hasNext()
			{
				return n > 0;
			}

			public Integer next()
			{
				n--;
				return IterableFibonacci.this.next();
			}

			public void remove()// Not implement
			{
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String[] args)
	{
		for(int i : new IterableFibonacci(18))
			System.out.println(i+" ");
	}
}
