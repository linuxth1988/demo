package org.ith.chapter8;

interface Inter1
{
	void f();
}

interface Inter2
{
	int f(int i);
}

interface Inter3
{
	int f();
}

class C 
{
	public int f()
	{
		return 1;
	}
}

class C2 implements Inter1,Inter2
{

	@Override
	public int f(int i)
	{
		return 1;
	}

	@Override
	public void f()
	{
		
	}
}

class C3 extends C implements Inter2
{
	@Override
	public int f(int i)
	{
		return 0;
	}
}



public class InterfaceTest
{

}
