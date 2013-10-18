package org.ith.t2013516;

/**
 * this program dimenstrates parameter passing in Java
 */
public class ParamTest
{
	public static void main(String[] args)
	{
		/**
		 * Test1 Methods can't modify numeric parameters
		 */
		System.out.println("Testing tripleValue:");
		double percent = 10;
		System.out.println("Before: percent= " + percent);
		tripValue(percent);
		System.out.println("After: percent= " + percent);
		
		
		/***
		 * Test2: Methods can change the state of Object parameters
		 */
		System.out.println("\nTeseting tripleSalary:");
		Employee harry = new Employee("Harry",50000);
		System.out.println("Before salary " + harry.getSalary());
		tripleSalary(harry);
		System.out.println("After salary " + harry.getSalary());
		
		
		/***
		 * Test3: Methods can't attach new objects to object parameters
		 */
		System.out.println("\nTesting swap:");
		Employee a = new Employee("Alice",700);
		Employee b = new Employee("Bob",600);
		
		System.out.println("Before: a= " + a.getName());
		System.out.println("Before: b= " + b.getName());
		
		swap(a,b);
		
		System.out.println("After: a= " + a.getName());
		System.out.println("After: b= " + b.getName());
		
	}

	private static void swap(Employee a, Employee b)
	{
		Employee temp = a;
		a = b;
		b = temp;
		System.out.println("End of method: a = " + a.getName());
		System.out.println("End of method: b = " + b.getName());
	}

	private static void tripleSalary(Employee harry)
	{
		harry.setSalary(125.5f);
	}

	private static void tripValue(double x)
	{
		x = 3 * x;
		System.out.println("End of method: x = " + x);
	}
}


class Employee
{
	private String name;
	private double salary;
	
	public Employee(String name,double salary)
	{
		this.name = name;
		this.salary = salary;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	@Override public String toString()
	{
		return name + ": "+ salary;
	}
	
}