package org.ith.chapter14;

import java.util.Random;

class Initable
{
	static final int staticFinal1 = 47;

	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

	static
	{
		System.out.println("初始化 Initable");
	}
}

class Initable2
{
	static int staticNonFial = 147;
	static
	{
		System.out.println("初始化 Initable2");
	}
}

class Initable3
{
	static int staticNonFinal = 74;

	static
	{
		System.out.println("初始化 Initable3");
	}
}

@SuppressWarnings({ "rawtypes", "unused" })
public class ClassInitialization
{
	public static Random rand = new Random(47);

	public static void main(String[] args) throws Exception
	{
		Class initable = Initable.class;
		System.out.println("after create initable ref");

		System.out.println(Initable.staticFinal1);

		System.out.println("-------------------------------");

		System.out.println(Initable.staticFinal2);

		System.out.println("before Class.forName init3");
		Class initable3 = Class.forName("org.ith.chapter14.Initable3");
		System.out.println("before Class.forName init3");


		System.out.println(Initable3.staticNonFinal);
		
		System.out.println("::::::::::::" + new ClassInitialization());

	}

}
