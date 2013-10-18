package org.ith.t2013513;
/**
 * ��������֪�����Լ���new�˶��ٻ�.
 * Ҫ�úÿ������ʼ��,�����ʼ����.
   @date 2013-05-13
 */
public class CountedObject
{
	private static long counter = 0;
	
	private final long id = ++counter;
	
	public long id()
	{
		return id;
	}
	
	@Override public String toString()
	{
		return "has created " +id + " times";
	}
	
	public static void main(String[] args)
	{
		for(int i = 0; i < 5; i++)
		{
			System.out.println(new CountedObject());
		}
	}
}
