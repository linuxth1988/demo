package org.ith.chapter10;

public class Sequence
{
	private Object[] items;
	private int next = 0;
	public Sequence(int size)
	{
		items = new Object[size];
	}
	
	public void add(Object x)
	{
		if(next < items.length)
		{
			items[next++] = x; 
		}
	}
	
	public static void main(String[] args)
	{
		Sequence seq = new Sequence(10);
		
		for(int i = 0; i < 10; i++)
		{
			seq.add(Integer.toString(i));
		}
		
		Selector selector = seq.selector();
		
		while(!selector.end())
		{
			System.out.print(selector.current()+"  ");
			selector.next();
		}
	}
	
	private class MyTest
	{
		private String str;
		
		public String toString()
		{
			return "ÏÔÊ¾: " + str;
		}
	}
	
	
	
	
	private class SequenceSelector implements Selector
	{
		private int i;
		
		@Override
		public boolean end()
		{
			return i == items.length;
		}

		@Override
		public Object current()
		{
			return items[i];
		}

		@Override
		public void next()
		{
			if(i < items.length)
				i++;
		}
	}
	
	public Selector selector()
	{
		return new SequenceSelector();
	}
}
