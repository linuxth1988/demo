package org.ith.t2013510;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T>
{
	private ArrayList<T> storage = new ArrayList<T>();
	
	private Random rand = new Random(47);
	
	public T select()
	{
		return storage.get(rand.nextInt(storage.size()));
	}
	
	public void add(T item)
	{
		storage.add(item);
	}
	
	public static void main(String[] args)
	{
		RandomList<String> rs = new RandomList<String>();
		
		for(String s : "The quick brown fox jumped over the lazy brown dog".split(" "))
		{
			rs.add(s);
		}
	}
}
