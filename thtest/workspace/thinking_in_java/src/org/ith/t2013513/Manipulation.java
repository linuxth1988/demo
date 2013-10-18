package org.ith.t2013513;


class HasF
{
	public void f()
	{
		System.out.println("HasF.f()");
	}
}

class Manipulator<T extends HasF>
{
	private T obj;
	
	public Manipulator(T x)
	{
		obj = x;
	}
	
	public void manipulate()
	{
		obj.f();
	}
}


public class Manipulation
{

}
