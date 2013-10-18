package org.ith.t2013509;

public class Position
{
	private String title;
	private Person person;
	
	public Position(String jobTitle,Person employee)
	{
		title = jobTitle;
		person = employee;
		
		if(person == null)
			person = Person.NULL;
	}
	
	public Position(String jobTitle)
	{
		title = jobTitle;
		person = Person.NULL;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(Person newPerson)
	{
		person = newPerson;
		if(person == null)
			person = Person.NULL;
	}
	
	public String toString()
	{
		return "Position: " + title + " " + person;
	}
}
