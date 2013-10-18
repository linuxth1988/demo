package org.ith.t2013518;

public class MethodTest
{
	public static void main(String[] args)
	{
		Parent parent = new Child();
		parent.f("");
		System.out.println(parent.getClass().getName());
	}
}

class Parent
{
	public void f(String str)
	{
		System.out.println("parent f");
	}
}

class Child extends Parent
{
	public void f(String str)
	{
		System.out.println("Child f");
	}
}
