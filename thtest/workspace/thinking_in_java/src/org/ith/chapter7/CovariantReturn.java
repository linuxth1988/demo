package org.ith.chapter7;

public class CovariantReturn
{
	public static void main(String[] args)
	{
		Mill m = new Mill();
		Graint g = m.process();
		System.out.println(g);

	}
}

class Graint
{
	@Override
	public String toString()
	{
		return "Graint";
	}
}

class Wheat extends Graint
{
	@Override
	public String toString()
	{
		return "Wheat";
	}
}

class Mill
{
	Graint process()
	{
		return new Graint();
	}
}

class WheatMill extends Mill
{
	Wheat process()
	{
		return new Wheat();
	}
}
