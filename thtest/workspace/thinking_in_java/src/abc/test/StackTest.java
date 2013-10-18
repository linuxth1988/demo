package abc.test;

public class StackTest
{
	public static void main(String[] args)
	{
		MyStack<String> mStack = new MyStack<String>();

		for (String str : "hello fucking beautiful".split(" "))
		{
			mStack.push(str);
			System.out.println(str);
		}

		System.out.println("--------------------------------------");

		String s;

		while ((s = mStack.pop()) != null)
			System.out.println( s);
	}
}

class MyStack<T>
{
	/**��סѹ��ջ����һ��Ԫ��*/
	private class Node<U>
	{
		/**��ѹ��ջ������*/
		U item;
		/**��סѹ��ջ����һ��Ԫ��*/
		Node<U> next;

		public Node()
		{
			item = null;
			next = null;
		}

		public Node(U item, Node<U> next)
		{
			this.item = item;
			this.next = next;
		}

		public boolean isEnd()
		{
			return item == null && next == null;
		}
	}

	private Node<T> the_next = new Node<T>();

	public void push(T item)
	{
		the_next = new Node(item, the_next);
	}

	public T pop()
	{
		T result = the_next.item;
		if (!the_next.isEnd())
			the_next = the_next.next;
		return result;
	}
}
