package org.ith.adapter_pattern;

/**
 * ��һ����Ľӿ�ת���ɿͻ�ϣ��������һ���ӿڡ� Adapterģʽʹ��ԭ�����ڽӿڲ����ݶ�����һ��������Щ�����һ������
 * 
 * 1.����ʹ��һ���Ѿ����ڵ��࣬�����Ľӿڲ������������
 * 
 * 2.���봴��һ�����Ը��õ��࣬�����������������ص���򲻿�Ԥ������ ������Щ�ӿڿ��ܲ�һ�����ݵ��ࣩЭͬ������
 * 
 * 3.���������ڶ���Adapter������ʹ��һЩ�Ѿ����ڵ����࣬ ���ǲ����ܶ�ÿһ�����������໯��ƥ�����ǵĽӿڡ� ���������������������ĸ���ӿڡ�
 */
public class Client
{
	public static void main(String[] args)
	{
		Target target = new Adapter(new Adaptee());
		target.adapteeMethod();
		target.adapterMethod();
	}
}
