package org.ith.chapter8;

import java.util.Random;

public class RandomDoubles
{
	private static Random rand = new Random(57);
	
	public double next()
	{
		return rand.nextDouble();
	}
	
	public static void main(String[] args)
	{
		RandomDoubles rd = new RandomDoubles();
		for(int i = 0; i < 7; i++)
			System.out.println(rd.next() + "  ");
	}
}
