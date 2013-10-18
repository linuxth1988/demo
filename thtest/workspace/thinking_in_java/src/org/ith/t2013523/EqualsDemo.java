package org.ith.t2013523;


class Value
{
	int i;
}
/*
 * 不重写equals的下场
 */
public class EqualsDemo
{
	public static void main(String[] args)
	{
		Value v1 = new Value();
		Value v2 = new Value();
		
		v1.i = v2.i = 100;
		
		System.out.println(v1.equals(v2));
		
	}
}
