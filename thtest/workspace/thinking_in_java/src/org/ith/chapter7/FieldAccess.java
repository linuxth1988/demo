package org.ith.chapter7;

class Super
{
	public int field = 0;

	public int getField()
	{
		return field;
	}
}

class Sub extends Super
{
	public int field = 1;

	public int getField()
	{
		return field;
	}

	public int getSuperField()
	{
		return super.field;
	}
}

public class FieldAccess
{
	public static void main(String[] args)
	{
		Super sp = new Sub();

		System.out.println(sp.getClass().getName()+"\tsp.field= " + sp.field + ",\t sp.getField()= " + sp.getField()+"\n\n");

		Sub sb = new Sub();

		System.err.println(sb.getClass().getName()+"\tsb.field= " + sb.field + ",\t sb.getField()= " + sb.getField() + "\t sb.getSuperField()= \t"
				+ sb.getSuperField());
	}
}
