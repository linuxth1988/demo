package org.ith.tuple;

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

	private Node<T> top = new Node<T>();

	public T pop()
	{
		T result = top.item;
		
		if (!top.end())
		{
			top = top.next;
		}

		return result;
	}

	public void push(T item)
	{
		top = new Node<T>(item, top);
	}

	public static void main(String[] args)
	{
		LinkedStack<String> stack = new LinkedStack<String>();

		for (String s : "fuck the fucking pain away for ever".split(" "))
		{
			stack.push(s);
			System.out.print(s+"  ");
		}

		System.out.println();	System.out.println();	System.out.println();
		
		String s;

		while ((s = stack.pop()) != null)
		{
			System.out.print(s+"  ");
		}
	}
}
