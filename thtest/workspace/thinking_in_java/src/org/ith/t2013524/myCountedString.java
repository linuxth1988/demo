package org.ith.t2013524;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * show you how to create a good hashcode
 */
public class myCountedString
{
	private static List<String> created = new ArrayList<String>();

	private String s;

	private int id = 0;

	public myCountedString(String str)
	{
		s = str;
		created.add(s);
		// id is the total number of instances of the string in use by
		// COunteString
		for (String s2 : created)
		{
			if (s2.equals(s))
				id++;
		}
	}

	public String toString()
	{
		return "String : " + s + " id: " + id + " hashcode: " + hashCode();
	}

	public int hashCode()
	{
		// The very simple approach: return s.hashcode() * id;
		// Using joshua Bloch's recipe;
		int result = 17;
		result = 37 * result + s.hashCode();
		result = 37 * result + id;
		return result;
	}

	@Override
	public boolean equals(Object other)
	{
		// return o instanceof CountedString && s.equals(((CountedString) o).s)
		// && id == (((CountedString) o).id);

		if (other == this)
			return true;
		if (other == null)
			return false;
		if (!(other instanceof myCountedString))
			return false;
		
		myCountedString ctr = (myCountedString) other;
		return ctr.s.equals(s) && ctr.id == id;

	}

	public static void main(String[] args)
	{
		Map<myCountedString, Integer> map = new HashMap<myCountedString, Integer>();
		myCountedString[] cs = new myCountedString[5];
		for (int i = 0; i < cs.length; i++)
		{
			cs[i] = new myCountedString("hi");
			System.out.println(" +++++  " + cs[i]);
			map.put(cs[i], i);
		}

		System.out.println(map);

		for (myCountedString coun : cs)
		{
			System.out.println("looking up " + coun);
			System.out.println(map.get(coun));
		}

		HashSet<String> str;
		
		
	}
}
