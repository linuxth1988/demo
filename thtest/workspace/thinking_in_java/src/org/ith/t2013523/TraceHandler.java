package org.ith.t2013523;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler
{
	public TraceHandler(Object t)
	{
		target = t;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		// print implicit argument
		System.out.print(target);
		//print method name
		System.out.print("."+method.getName()+"(");
		//print explicit arguments
		if(args != null)
		{
			for(int i = 0; i < args.length; i++)
			{
				System.out.print(args[i]);
				
				if(i < args.length - 1)
					System.out.print(", ");
			}
		}
		System.out.println(")");
		
		return method.invoke(target, args);
	}
	
	private Object target;
}
