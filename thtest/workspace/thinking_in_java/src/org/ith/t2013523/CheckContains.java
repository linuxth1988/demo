package org.ith.t2013523;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CheckContains
{
	public static void main(String[] args)
	{
		ArrayList<String> lists = new ArrayList<String>();
		lists.contains("str");

		HashSet<String> set = new HashSet<String>();
		set.contains("a");

		HashSet<Person> hs = new HashSet<Person>();

		hs.contains("a");

		Person p1 = new Person("name1", 1);
		Person p2 = new Person("name2", 2);
		Person p3 = new Person("name3", 3);
		Person p4 = new Person("name4", 4);

		hs.add(p2);
		hs.add(p1);
		hs.add(p4);
		hs.add(p3);

		new Object().toString();

		Person p5 = new Person("name5", 5);
		System.out.println(hs.size());
		System.out.println(hs.contains(p5));
		System.out.println(hs.toString());

		long start = System.currentTimeMillis();
		HashMap<String, String> hm = new HashMap<String, String>(10000);
		hm.containsKey("a");
		long end = System.currentTimeMillis();
		System.out.println((end - start));

		start = System.currentTimeMillis();
		ArrayList<String> al = new ArrayList<String>(10000);
		al.contains("a");
		end = System.currentTimeMillis();
		System.out.println((end - start));

	}
}

class Person
{
	private String name;
	private int age;

	public Person()
	{
	}

	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public boolean equals(Object otherObj)
	{
		if (this == otherObj)
			return true;
		if (otherObj == null)
			return false;
		if (otherObj.getClass() != getClass())
			return false;
		Person p = (Person) otherObj;
		return name.equals(p.name) && age == p.age;
	}

	@Override
	public String toString()
	{
		return name + ": " + age;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	@Override
	public int hashCode()
	{
		return 1;
	}
}
