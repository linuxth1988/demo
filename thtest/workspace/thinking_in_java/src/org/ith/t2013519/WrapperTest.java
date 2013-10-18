package org.ith.t2013519;

public class WrapperTest
{
	public static void main(String[] args)
	{
		Integer t1 = new Integer(1);
		Integer t2 = new Integer(1);
		
		t1 = 300;
		t2 = 300;
		
		System.out.println("==\t" + (t1 == t2));
		System.out.println("equals\t" + t1.equals(t2));
	}
}
