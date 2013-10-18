package org.ith.chapter14;

import java.util.Arrays;
import java.util.List;

public class Shapes
{
	public static void main(String[] args)
	{
//		test();
		
		identifyArray(new char[]{'a','b'});
		
		System.out.println("---------------");
		
		identifyArray(new char[]{new Character('a'),new Character('b')});
	}
	
	
	public static String identifyArray(char[] chs)
	{
		String result = "";
		
		result = chs.getClass().getCanonicalName();

		System.out.println(result);
		
		return result;
	}
	

	private static void test()
	{
		List<Shape> shapeList = Arrays.asList(new Circle(),new Square(),new Triangle());
		
		for(Shape sh : shapeList)
		{
			sh.draw();
		}
	}
}
