package org.ith.t2013513;

import java.util.ArrayList;

public class ErasedTypeEquivalence
{
	public static void main(String[] args)
	{
		Class c1 = new ArrayList<Integer>().getClass();
		Class c2 = new ArrayList<String>().getClass();
		
		System.out.println("c1.class " + c1);
		System.out.println("c2.class " + c2);
		
		System.out.println(c1 == c2);
	}
}
