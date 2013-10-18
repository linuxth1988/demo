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
	 * 不知道从哪里看来的结论,说是你的方法最好不要有好几个出口,
	 * 意思是只要有一个return的地方. 这时如果像下面这么写的话.
	 * 那么本来str长度为1时直接就应该返回了的情况.也要判断三遍
	 * 才会返回.while处有2次,第2次才跳出的
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
