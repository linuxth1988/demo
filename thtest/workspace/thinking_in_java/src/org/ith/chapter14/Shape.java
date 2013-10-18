package org.ith.chapter14;

public abstract class Shape
{
	void draw()
	{
		System.out.println(this + " .draw");
	}

	abstract public String toString();
}

class Circle extends Shape
{
	public String toString()
	{
		return "Circle";
	}
}

class Square extends Shape
{
	public String toString()
	{
		return "Square";
	}
}

class Triangle extends Shape
{
	public String toString()
	{
		return "Triangle";
	}
}
