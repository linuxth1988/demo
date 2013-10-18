package org.ith.t2013518;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
/**
hashCode����ǳ��
��������һ���������Ƿ����ĳ����,��ų���Ӧ����ôд��?
��ͨ���Ǳ����ü���Ȼ�����������бȽ�,������ĳ��Ԫ����Ҫ���ҵĶ������
equals�����ȽϵĽ�����ʱ,��ֹͣ��������.���һ���������кܶ��Ԫ��,��ô
����ζ���������ķ���Ч�ʾͼ������.���Ǿ����˷�����һ�ֹ�ϣ�㷨����ߴӼ���
�в���Ԫ�ص�Ч��,���ַ�ʽ�����Ϸֳ����ɸ��洢����,ÿ��������Լ����һ��hash��,
���Խ�hash�����,ÿ��ֱ��Ӧĳ���洢����,����һ�������hash��Ϳ���ȷ���ö���Ӧ
�ô洢���ĸ�����.��Ȼ��,������������,�Ǿ�����ļ�����hash����.����û�м�ֵ.
ֵ��ע�����,һ�������Ļ�,�����������equals�ȽϷ���trueʱ,��ô���Ӧ��������
��hashcodeֵ���.��仰����˼��˵,��Ϊ��hash������,Ԫ�ر���ŵ�λ��������hashֵ
��������,���������ȵĶ����hashֵ��ͬ�Ļ�,��ô�ͻᱻ��ŵ���ͬ��λ��,Ҳ����˵
��ļ��Ͻ�������ȵ�����,�����ʵ����������.

��һ�����󱻴洢��hash���Ϻ�,�Ͳ����޸������������Щ�������hashcodeֵ���ֶ���,
����,�����޸ĺ��hashֵ��������뼯����hashֵ�Ͳ�һ����,�����������,��ʹ���
contains�������������Ҳ����ö�����,��Ҳ�ᵼ�����޷��Ӹ�hash�����е���ɾ����ǰ
����,�Ӷ�����ڴ�й©.* 
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
		
		//�Ķ��˲���hashcode�����ֵ,���޷�ɾ����,��leak memery
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