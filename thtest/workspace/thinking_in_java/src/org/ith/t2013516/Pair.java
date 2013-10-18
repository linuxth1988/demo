package org.ith.t2013516;

public class Pair<T>
{
	public Pair()
	{
		first = null;
		second = null;
	}
	
	public T getFirst()
	{
		return first;
	}
	
	public T getSecond()
	{
		return second;
	}
	
	public void setFirst(T newValue)
	{
		first = newValue;
	}
	
	public void setSecond(T newValue)
	{
		second = newValue;
	}
	
	private T first;
	private T second;
}
