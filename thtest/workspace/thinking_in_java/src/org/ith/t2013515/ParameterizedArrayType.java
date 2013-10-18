package org.ith.t2013515;

class ClassParameter<T>
{
	public T[] f(T[] arg)
	{
		return arg;
	}
}

class MethodParameter
{
	public static <T> T[] f(T[] arg)
	{
		return arg;
	}
}

public class ParameterizedArrayType
{
	public static void main(String[] args)
	{
		Integer[] ints = { 1, 2, 3, 4, 5 };
		Double[] doubles = { 1.1, 2.2, 3.3, 4.4 };
		Integer[] ints2 = new ClassParameter<Integer>().f(ints);

		Double[] doubles2 = new ClassParameter<Double>().f(doubles);

		ints2 = MethodParameter.f(ints2);
		doubles2 = MethodParameter.f(doubles2);
		
		String str = "abcdefg";
		System.out.println(str.substring(0,3));
	}
	
	public static void tripleValue(double x)
	{
		x = 3 * x;
	}
}
