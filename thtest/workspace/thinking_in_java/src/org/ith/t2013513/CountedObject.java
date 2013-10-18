package org.ith.t2013513;
/**
 * 这个类可以知道它自己被new了多少回.
 * 要好好看下类初始化,对象初始化了.
   @date 2013-05-13
 */
public class CountedObject
{
	private static long counter = 0;
	
	private final long id = ++counter;
	
	public long id()
	{
		return id;
	}
	
	@Override public String toString()
	{
		return "has created " +id + " times";
	}
	
	public static void main(String[] args)
	{
		for(int i = 0; i < 5; i++)
		{
			System.out.println(new CountedObject());
		}
	}
}
