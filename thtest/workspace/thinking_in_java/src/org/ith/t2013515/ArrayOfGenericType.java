package org.ith.t2013515;

public class ArrayOfGenericType<T>
{
	T[] array;
	
	public ArrayOfGenericType(int size)
	{
		//!  array = new T[size];   Illegal
		array = (T[])new Object[size];
	}
	
	//Illegal
	public <U> U[] nakeArray()
	{
//		return new U[10];
		return (U[])new Object[10];
	}
}
