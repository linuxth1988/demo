package abc.test;

public class T2
{
	public static void main(String[] args)
	{
		TStack<String> ts = new TStack<String>();
		
		for(String s : "this is my stack".split(" "))
		{
			System.out.println(s);
			ts.push(s);
		}
		
		System.out.println("----------");
		String s;
		
		while((s = ts.pop()) != null)
			System.out.println(s);
	}
}

class TStack<FF>
{
	private class Node<AA>
	{
		AA item;
		Node<AA> next;
		
		Node()
		{
			item = null;
			next = null;
		}
		
		Node(AA item,Node<AA> next)
		{
			this.item = item;
			this.next = next;
		}
		
		public boolean isEnd()
		{
			return item == null && next == null;
		}
	}
	
	private Node<FF> rem = new Node<FF>();
	
	public void push(FF item)
	{
		rem = new Node<FF>(item, rem);
	}
	
	public FF pop()
	{
		FF result = rem.item;
		if(!rem.isEnd())
			rem = rem.next;
		return result;
	}
	
	
	
	
}
