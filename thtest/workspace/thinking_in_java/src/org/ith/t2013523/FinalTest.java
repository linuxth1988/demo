package org.ith.t2013523;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

public class FinalTest
{
	//这个方法想统计compareTo方法被执行过几次,但这样不行
	public static void test1()
	{
		int counter = 0;
		Date[] dates = new Date[100];
		
		for(int i = 0; i < dates.length; i++)
		{
			dates[i] = new Date()
			{
				public int compareTo(Date anotherDate) 
				{
//					counter++;		//err
					return super.compareTo(anotherDate);
				};
			};
		}
		
		Arrays.sort(dates);
		System.out.println(counter);
	}
	
	
	@SuppressWarnings("serial")
	public static void test2()
	{
		final int[] counter = new int[1];
		Date[] dates = new Date[100];
		
		for(int i = 0; i < dates.length; i++)
		{
			dates[i] = new Date()
			{
				@Override public int compareTo(Date anotherDate) 
				{
					++counter[0];
					return super.compareTo(anotherDate);
				};
			};
		}
		Arrays.sort(dates);
		System.out.println(counter[0]);
	}
	
	public static void main(String[] args)
	{
		test2();
		 
	}
}

class T2
{
	public void start(int interval,final boolean beep)
	{
		ActionListener listener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Date now = new Date();
				System.out.println("At the tone,the time is "+ now);
			}
		};
	}



}








































