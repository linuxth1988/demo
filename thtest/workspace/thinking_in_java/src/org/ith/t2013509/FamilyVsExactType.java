package org.ith.t2013509;


class Base
{
}

class Derived extends Base
{
}

public class FamilyVsExactType
{
	static void test(Object x)
	{
		System.out.println("Testing x of type:" +x.getClass());
		System.out.println("x instanceof Base:¡¡"+(x instanceof Base));
		System.out.println("x instanceof Derived:¡¡"+(x instanceof Derived));
		System.out.println("Base.isInsance(x) " + Base.class.isInstance(x));
		System.out.println("Derived");
		
	}
	
	public static void main(String[] args)
	{
		test(new Derived());
	}
}
