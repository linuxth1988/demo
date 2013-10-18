package org.ith.t2013515;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics
{
	@SuppressWarnings("uncheked")
	public static void main(String[] args)
	{
		List<String>[] ls;
		
		List[] la = new List[10];
		
		ls = (List<String>[])la;
		
		ls[0] = new ArrayList<String>();
		
		//compile-time checking produces an error
//		ls[1] = new ArrayList<Integer>();
		
		//The problem: if your needs are straightforward it is possible
		//to create an array of generic,albeit with an "uncheck" warning;
	 
	}
}
