package org.ith.t2013518;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
/**
hashCode方法浅析
如果想查找一个集合中是否包含某对象,大概程序应该怎么写呢?
你通常是遍历该集合然后逐个对象进行比较,当发现某个元素与要查找的对象进行
equals方法比较的结果相等时,则停止继续查找.如果一个集合中有很多个元素,那么
就意味着你这样的方法效率就极其低了.于是就有人发明了一种哈希算法来提高从集合
中查找元素的效率,这种方式将集合分成若干个存储区域,每个对象可以计算出一个hash码,
可以将hash码分组,每组分别对应某个存储区域,根据一个对象的hash码就可以确定该对象应
该存储在哪个区域.当然了,这是有条件的,那就是你的集合是hash集合.否则没有价值.
值得注意的是,一句著名的话,当两个对象的equals比较返回true时,那么你就应该让他们
的hashcode值相等.这句话的意思是说,因为在hash集合中,元素被存放的位置是由其hash值
所决定的,如果两个相等的对象的hash值不同的话,那么就会被存放到不同的位置,也就是说
你的集合将存入相等的数据,这就与实际情况相悖了.

当一个对象被存储进hash集合后,就不能修改这个对象中那些参与计算hashcode值的字段了,
否则,对象修改后的hash值与最初存入集合中hash值就不一样了,在这种情况下,即使你的
contains方法将告诉你找不到该对象了,这也会导致你无法从该hash集合中单独删除当前
对象,从而造成内存泄漏.* 
 *
 */
@SuppressWarnings({ "rawtypes","unchecked"})
public class ReflectTest
{
	public static void main(String[] args)
	{
		Collection mCollection = new HashSet();
		Point pt0 = new Point(3, 3);
		Point pt1 = new Point(1, 4);
		Point pt2 = new Point(3, 3);
		
		new Object().hashCode();
		
		new java.util.HashSet().contains(pt0);
		
		mCollection.add(pt0);
		mCollection.add(pt1);
		mCollection.add(pt2);
		mCollection.add(pt0);
		System.out.println(mCollection.size());
		
		System.out.println("-----------------before----------------");
		for(Object ct : mCollection)
			System.out.println(ct);
		System.out.println("-----------------before----------------");
		
		//改动了参与hashcode计算的值,则无法删除了,会leak memery
		pt0.setX(12);
		mCollection.remove(pt0);
		

		System.out.println("-----------------after----------------");
		for(Object ct : mCollection)
			System.out.println(ct);
		System.out.println("-----------------after----------------");
		
		
		System.out.println(pt0);
		System.out.println(mCollection.contains(pt0));
		
	 
	}
}

class Point
{
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	private int x, y;

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}
	
	@Override public String toString()
	{
		return "("+x+", "+ y+")" + "  "+hashCode();
	}

	 @Override
	 public int hashCode()
	 {
	 final int prime = 31;
	 int result = 1;
	 result = prime * result + x;
	 result = prime * result + y;
	 return result;
	 }

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public void setY(int y)
	{
		this.y = y;
	}

}