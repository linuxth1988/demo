package thread.zxx.ith;

public class ThreadCommunation
{
	public static void main(String[] args)
	{
		Q q = new Q();

		new Thread(new Producer(q)).start();
		new Thread(new Consumer(q)).start();
	}
}

class Producer implements Runnable
{
	Q q = null;

	public Producer(Q q)
	{
		this.q = q;
	}

	@Override
	public void run()
	{
		int i = 0;

		while (true)
		{
			synchronized (ThreadCommunation.class)
			{
				if (i == 0)
				{
					q.name = "ÎâÑå×æ";
					q.sex = "ÄĞ";
				}
				else
				{
					q.name = "ÁøÑÒ";
					q.sex = "Å®";
				}

				i = (i + 1) % 2;
			}
		}
	}
}

class Consumer implements Runnable
{
	Q q = null;

	public Consumer(Q q)
	{
		this.q = q;
	}

	@Override
	public void run()
	{
		while (true)
		{
			synchronized (ThreadCommunation.class)
			{
				System.out.println(q.name + "--------> " + q.sex);
			}
		}
	}
}

class Q
{
	String name = "ÁøÑÒ";
	String sex = "Å®";
}