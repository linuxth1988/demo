package interfaces.interfaceprocessor;

import interfaces.interfaceprocessor.Outer.Inner;

public class InnerTest1
{
	public static void main(String[] args)
	{
		Outer out = new Outer();
		Inner in = out.getInner();
		System.out.println(in.getClass().getName());
	}
}

class Outer
{
	class Inner
	{
		
	}
	public Inner getInner()
	{
		return new Inner();
	}
}