package org.ith.tuple;

public class StringInvert
{
	public static void main(String[] args)
	{
		String str = "a";
		System.out.println("-" + (str)+"-");
		System.out.println();
		System.out.println("-" + InvertStr(str)+"-");
	}
	
	
	/***
	 * ��֪�������￴���Ľ���,˵����ķ�����ò�Ҫ�кü�������,
	 * ��˼��ֻҪ��һ��return�ĵط�. ��ʱ�����������ôд�Ļ�.
	 * ��ô����str����Ϊ1ʱֱ�Ӿ�Ӧ�÷����˵����.ҲҪ�ж�����
	 * �Ż᷵��.while����2��,��2�β�������
	 @date	2013-05-11 0:16
	 */
	public static String InvertStr(String str)
	{
		String result = "";
		
		if(str == null || str.length() ==1)
			result = str;
		
		char[] chs = str.toCharArray();
		int start = 0;
		int end = chs.length-1;
		
		while(start <= end)
		{
			char middle ;
			middle = chs[start];
			chs[start] = chs[end];
			chs[end] = middle;
			start++;
			end--;
		}
		
		result = new String(chs);
		return result;
	}
}
