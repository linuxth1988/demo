package org.ith.chapter8;

import java.util.Arrays;
/**
����������һ���ܹ����������ݵĲ�������ͬ,�����в�ͬ��Ϊ�ķ���,
����Ϊ����ģʽ.���෽��������Ҫִ�е��㷨�й̶�����Ĳ���,������
�����仯�Ĳ���.���Ծ��Ǵ��ݽ�ȥ�Ĳ�������,������Ҫִ�еĴ���.
 */
public class Apply
{
	public static void process(Processor p, Object s)
	{
		System.out.println("Using processor" + p.name());
		System.out.println(p.process(s));
	}

	public static String s = "Disagreement with beliefs is by definition incorrect";

	public static void main(String[] args)
	{
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);
		
//		process(new Filter(),s);
	}
}

class Processor
{
	public String name()
	{
		return this.getClass().getSimpleName();
	}

	Object process(Object input)
	{
		return input;
	}
}

class Upcase extends Processor
{
	String process(Object input)
	{
		return ((String) input).toUpperCase();
	}
}

class Downcase extends Processor
{
	String process(Object input)
	{
		return ((String) input).toLowerCase();
	}
}

class Splitter extends Processor
{
	String process(Object input)
	{
		return Arrays.toString(((String) input).split(" "));
	}
}
