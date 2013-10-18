package org.ith.t2013513;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class News
{
	public static <K,V> Map<K,V> map()
	{
		return new HashMap<K,V>();
	}
	
	public static void main(String[] args)
	{
		List<String> t1 = new ArrayList<String>();
		List<Integer> t2 = new ArrayList<Integer>();
		System.out.println(t1.getClass());
	}
	
	
}
