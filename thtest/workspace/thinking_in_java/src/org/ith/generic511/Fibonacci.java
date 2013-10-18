package org.ith.generic511;

interface MyGernerator<T>
{
	T next();
}

/**
 * 负责生成Fibonacci数列
 */
public class Fibonacci implements MyGernerator<Integer>
{
	private int count = 0;
	
	public Fibonacci(){}
	
	@Override
	public Integer next()
	{
		return fib(count++);
	}
	
	private int fib(int n)
	{
		if(n < 2)
			return 1;
		return fib(n-2)+fib(n-1);
	}
	
	public static void main(String[] args)
	{
		Fibonacci fb = new Fibonacci();
		for(int i = 0; i < 10; i++)
			System.out.print(fb.next()+" ");
	}
}
