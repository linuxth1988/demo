package org.ith.t2013516;

import java.util.Arrays;

public class MethodParam
{
	public static void main(String[] args)
	{
		/*Pig p1 = new Pig("hello",1);
		Pig p2 = new Pig("world",2);
		
		System.out.println("before swap    p1 = " + p1 + "\t   p2 = " + p2);
		
		swapPig(p1,p2);
	
		System.out.println("after swap    p1 = " + p1 + "\t   p2 = " + p2);
		
		int a = 1;
		int b = 2;
		swapNum(a,b);
		
		System.out.println(Arrays.toString(swap(a,b)));*/
		
		
		
		
		
		
		
	}
	
	
	public static int[] swapArray(int... a)
	{
		
		
		
		return new int[]{};
	}
	
	
	public static void swapPig(Pig p1,Pig p2)
	{
		Pig temp = p1;
		p1 = p2;
		p2 = temp;
	}
	
	public static int[] swap(int a, int b)
	{
		int temp = b;
		b = a;
		a = temp;
		
		return new int[]{a,b};
	}
	
	public static void swapNum(int a, int b)
	{
		int temp = a;
		a = b;
		b = temp;
	}
}

class Pig
{
	private int age;
	private String name;
	
	public Pig(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	
	@Override public String toString()
	{
		return "("+name + ", "+ age + ")";
	}
}
