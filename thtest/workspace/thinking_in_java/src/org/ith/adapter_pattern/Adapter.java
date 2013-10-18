package org.ith.adapter_pattern;
/**
 * 对Adaptee的接口与Target接口进行适配
 */
public class Adapter implements Target
{
	private Adaptee adaptee;

	public Adapter(Adaptee adaptee)
	{
		this.adaptee = adaptee;
	}

	public void adapteeMethod()
	{
		adaptee.adapteeMethod();
	}

	public void adapterMethod()
	{
		System.out.println("Adapter method!");
	}
}
