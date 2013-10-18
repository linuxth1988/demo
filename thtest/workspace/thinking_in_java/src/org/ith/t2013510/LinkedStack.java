package org.ith.t2013510;

/***
�������ʹ����һ��ĩ���ڱ�(end sentinel)���ж϶�ս��ʱΪ��.
���ĩ���ڱ����ڹ���LinkedStackʱ������.Ȼ��,ÿ����һ��push
����,�ͻᴴ��һ��Node<T>����,���������ӵ�ǰһ��Node<T>����.
�������pop()����ʱ,���Ƿ���top.item,Ȼ������ǰtop��ָ��
Node<T>,����topת�Ƶ���һ��Node<T>,�������Ѿ�����ĩ���ڱ���,
��ʱ��Ͳ����ƶ�top��.����Ѿ�����ĩ��.�ͻ��˳��򻹼�������
pop����,����ֻ�ܵõ�null,˵����ջ�Ѿ���

 * @author thank1988
 * @date 2013-5-10
 * @param <T>
 */
public class LinkedStack<T>
{
	private static class Node<U>
	{
		U item;

		Node<U> next;

		Node()
		{
			item = null;
			next = null;
		}

		Node(U item, Node<U> next)
		{
			this.item = item;
			this.next = next;
		}

		boolean end()
		{
			return item == null && next == null;
		}
	}

	private Node<T> top = new Node<T>();	// the end sentinel

	public void push(T item)
	{
		top = new Node<T>(item, top);
	}

	public T pop()
	{
		T result = top.item;
		if (!top.end())
		{
			top = top.next;
		}

		return result;
	}

	public static void main(String[] args)
	{
		LinkedStack<String> lss = new LinkedStack<String>();
		
		for (String s : "Phasers on stun!".split(" "))
		{
			lss.push(s);
		}

		String s;

		while ((s = lss.pop()) != null)
		{
			System.out.println(s);
		}
	}
}
