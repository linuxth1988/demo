package org.ith.t2013515;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayTest
{
	public static void main(String[] args)
	{
		String[] str = new String[5];
		str[0] = "a";
		str[1] = "c";
		str[2] = "b";
		
		for(int i = 0; i < str.length; i++)
		{
			System.out.println(str[i]);
		}
		
		System.out.println("-------------------------------------------");
		
		for(String st:str)
			System.out.println(st);
		
		for(int i = 0; i < 3; i++)
			System.out.println("str["+i+"]= " + str[i]);
		
		@SuppressWarnings("rawtypes")
		ArrayList<String> al = new ArrayList<String>(10);
		System.out.println(al.size());
		
		String[] strs = new String[19];
		strs = str;
		System.out.println(strs.length);
		
		
		int[][] a = 
		{
				{1,2,3},
				{4,5}
		};
		
		System.out.println(Arrays.deepToString(a));
		
		
		int [][][] b = new int[3][][];
		System.out.println(b.length);
		
		Random rand = new Random(47);
		int[][][] ar = new int[rand.nextInt(4)][][];
		for(int i = 0; i < ar.length; i++)
		{
			ar[i] = new int[rand.nextInt(5)][];
			
			for(int j = 0; j < ar[i].length;j++)
			{
				ar[i][j] = new int[rand.nextInt(5)];
			}
		}
		
		System.out.println(Arrays.deepToString(ar));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}	
