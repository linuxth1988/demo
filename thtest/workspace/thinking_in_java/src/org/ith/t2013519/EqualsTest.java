package org.ith.t2013519;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * this program demonstrates the equals method
 */
public class EqualsTest
{
	public static void main(String[] args)
	{
		Employee0 alice1 = new Employee0("Alice Adams", 7500, 1987, 12, 15);
		Employee0 alice2 = alice1;
		Employee0 alice3 = new Employee0("Alice Adams", 7500, 1987, 12, 15);
		Employee0 bob = new Employee0("Bob Brandson", 500, 1989, 10, 1);

		System.out.println("alice1 == alice2: " + (alice1 == alice2));
		System.out.println("alice1 == alice3: " + (alice1 == alice3));
		System.out.println("alice1.equals(alice3): " + (alice1.equals(alice3)));
		System.out.println("alice1.equals(bob): " + (alice1.equals(bob)));
		System.out.println("bob.toString() " + bob.toString());
		
		java.util.ArrayList<String> s;
		
		Manager carl = new Manager("Carl Cracker",80000,1987,12,5);
		Manager boss = new Manager("Carl Cracker",80000,1987,12,5);
		boss.setBonus(5000);
		System.out.println("carl.equals(boss): " + carl.equals(boss));
		System.out.println("alice1.hashcode():   " + alice1.hashCode());
		System.out.println("alice3.hashcode():   " + alice3.hashCode());
		System.out.println("bob.hashcode():   " + bob.hashCode());
	}
}

class Employee0
{
	public Employee0(String n, double s, int year, int month, int day)
	{
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		hireDay = calendar.getTime();
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

	public Date getHireDay()
	{
		return hireDay;
	}

	public void setHireDay(Date hireDay)
	{
		this.hireDay = hireDay;
	}

	@Override
	public boolean equals(Object otherObj)
	{
		if (this == otherObj)
			return true;

		if (otherObj == null)
			return false;

		if (getClass() != otherObj.getClass())
			return false;

		Employee0 other = (Employee0) otherObj;

		return name.equals(other.name) && salary == other.salary && hireDay.equals(other.hireDay);
	}
	
	@Override public int hashCode()
	{
		return 7 * name.hashCode() + 11*new Double(salary).hashCode()+13*hireDay.hashCode();
	}

	private String name;
	private double salary;
	private Date hireDay;
}

class Manager extends Employee0
{
	public Manager(String n, double s, int year, int month, int day)
	{
		super(n,s,year,month,day);
		bonus = 0;
	}
	
	public double getSalary()
	{
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double b)
	{
		bonus = b;
	}
	
	@Override public boolean equals(Object otherObj)
	{
		if(!super.equals(otherObj))
			return false;
		
		Manager other = (Manager)otherObj;
		//Notice: super.equals checked that this and other belong to the same class
		return bonus == other.bonus;
	}
	
	@Override public int hashCode()
	{
		return super.hashCode()+ 17 * new Double(bonus).hashCode();
	}
	
	private double bonus;
}