package org.ith.chapter8_interface;

import java.util.Arrays;
 
public class Apply
{
	public static void process(Processor p, Object s)
	{
		System.err.println("Using processor" + p.name());
		System.out.println(p.process(s));
	}

	public static String s = "Disagreement with beliefs is by definition incorrect";

	public static void main(String[] args)
	{
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);
		
	}
}

interface Processor
{
	String name();
	Object process(Object input);
}

abstract class StringProcessor implements Processor
{
	public String name()
	{
		return this.getClass().getSimpleName();
	}
}

class Upcase extends StringProcessor
{
	public  String process(Object input)
	{
		return ((String) input).toUpperCase();
	}
}

class Downcase extends StringProcessor
{
	public String process(Object input)
	{
		return ((String) input).toLowerCase();
	}
}

class Splitter extends StringProcessor
{
	public String process(Object input)
	{
		return Arrays.toString(((String) input).split(" "));
	}
}
