package org.ith.t2013519;

/**
 * 演示equals方法的使用
 */
public class MyEquals
{
}

class MyEmployee
{
	private String name;
	private double salary;
	private java.util.Date hireDay;
	
	@Override public boolean equals(Object other)
	{
		//a quick test to see if the objects are identical
		if(other == this)
			return true;
		
		if(other == null)
			return false;
		
		//if the classes don't match,they can't be equal
		if(getClass() != other.getClass())
			return false;
		
		//test whether the fields have identical values
		MyEmployee emp = (MyEmployee)other;
		return name.equals(emp.name) && salary == emp.salary && hireDay.equals(emp.hireDay);
	}
}
