package org.ith.t2013516;

public class ReferenceDemo
{
	public static void swap(Emplo x, Emplo y)
	{
		Emplo temp = x;
		x = y;
		y = temp;
	}
	
	public static void main(String[] args)
	{
		Emplo employ_a = new Emplo("tangh", 25);
		Emplo employ_b = new Emplo("liujx", 30);
		
		System.out.println("before swap");
		System.out.println("a = " + employ_a);
		System.out.println("b = " + employ_b);
		
		swap(employ_a,employ_b);
		
		System.out.println("after swap");
		
		System.out.println("a = " + employ_a);
		System.out.println("b = " + employ_b);
		
		
		System.out.println("++++++++++++++++++++++++");
		
		int a = 1;
		int b = 2;
		swapNum(a,b);
		
		System.out.println("+++++++++++++++++++++++++++++++");
		
		Emplo emp = new Emplo("name",11);
		System.out.println("emp = " + emp);
		change(emp);
		System.out.println("emp = " + emp);
		
		
	}
	
	public static void change(Emplo emp)
	{
		 emp.setName("change_name");
	}
	
	
	
	
	public static void swapNum(int a,int b)
	{
		System.out.println("方法内部begin_________________________________");
		
		System.out.println("a = " + a + ", b =" + b);
		
		int temp = a;
		a = b;
		b = temp;
		
		System.out.println("a = " + a + ", b =" + b);
		
		System.out.println("方法内部end_________________________________");
	}
}

class Emplo
{
	private String name;
	private int age;
	
	public String getName()
	{
		return name;
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

	public Emplo(String name,int age)
	{
		this.name = name;
		this.age = age;
	}

	@Override public String toString()
	{
		return "name= " + name + ", age= " + age;
	}
}
