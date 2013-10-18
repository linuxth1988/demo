package org.ith.t2013513;

import java.util.ArrayList;
import java.util.List;

public class MyTest
{

}


interface MyInter
{
	void method1();
	void method2();
}

class My1 implements MyInter
{
	@Override
	public void method1()
	{
		System.out.println("My1 method1");
	}

	@Override
	public void method2()
	{
		System.out.println("My1 method1");
	}
	
	public void oterhMethod()
	{
		System.out.println("My1 otherMethod");
	}
}

class My2< T extends List>  implements MyInter 
{
	@Override
	public void method1()
	{
						
	}

	@Override
	public void method2()
	{
		
	}
	
	public void method(T t)
	{
		System.out.println(t);
	}
	
}
