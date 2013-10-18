package org.ith.t2013516;

public class MyReview
{
	/***
	 * boolean 只说了能存储字面值true和false.  byte 1字节   char,short 2字节 int,float 4字节 double
	 * long 8字节
	 */

	public static void main(String s[])
	{
//		findMaxAndMin(new int[] { 1, 3, 7, 3, 2, 8 ,-11,56,11,45});
		
		
	}

	public static void findMaxAndMin(int[] arr)
	{
		if (arr.length == 0)
			return;

		int min_index = 0, max_index = 0;

		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] > arr[max_index])
				max_index = i;
			if (arr[i] < arr[min_index])
				min_index = i;
		}

		System.out.println("max = " + arr[max_index] + ", min= " + arr[min_index]);
	}
}
