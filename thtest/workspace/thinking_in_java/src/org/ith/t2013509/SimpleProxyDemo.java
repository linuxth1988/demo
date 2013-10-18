package org.ith.t2013509;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleProxyDemo
{
	public static void consumer(Interface iface)
	{
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	
	public static void main(String[] args)
	{
//		consumer(new RealObject());
//		System.out.println("----------------------------------");
//		consumer(new SimpleProxy(new RealObject()));
		
		RealObject real = new RealObject();
		consumer(real);
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		
		Interface proxy = (Interface)Proxy.newProxyInstance
		(Interface.class.getClassLoader(), 
		 new Class[]{Interface.class},
		 new DynamicProxyHandler(real)	
		);
		
		consumer(proxy);
	}
}

interface Interface
{
	void doSomething();
	void somethingElse(String args);
}

class RealObject implements Interface
{
	@Override
	public void doSomething()
	{
		System.out.println("doSomething");
	}

	@Override
	public void somethingElse(String args)
	{
		System.out.println("somethingElse " +args);
	}
}

class SimpleProxy implements Interface
{
	private Interface proxied;
	
	public SimpleProxy (Interface proxied)
	{
		this.proxied = proxied;
	}
	
	@Override
	public void doSomething()
	{
		System.out.println("Simple Proxy doSomething");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String args)
	{
		System.out.println("Simple somethingElse");
		proxied.somethingElse(args);
	}
}

class DynamicProxyHandler implements InvocationHandler
{
	private Object proxied;
	
	public DynamicProxyHandler(Object proxied)
	{
		this.proxied = proxied;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		System.out.println("****proxy:** " + proxy.getClass() + ", method: " + method + ", args = " +args);
		
		if(args != null)
		{
			for(Object arg : args)
			{
				System.out.println("  " + arg);
			}
		}
		
		return method.invoke(proxied, args);
	}
}





































