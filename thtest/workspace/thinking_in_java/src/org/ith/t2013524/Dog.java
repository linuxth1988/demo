package org.ith.t2013524;

import java.util.Random;

/**
 Looks plausible,but doesn't work as a HashMap key
 */
public class Dog
{
	protected int number;
	public Dog(int n)
	{
		number = n;
	}
	
	public String toString()
	{
		return "dog # " +number;
	}
}

class Prediction
{
	private static Random rand = new Random(47);
	private boolean shadow = rand.nextDouble() > 0.5;
	
	public String toString()
	{
		if(shadow)
			return "Six more weeks of Winter!";
		else
			return "Early Spring!";
	}
}