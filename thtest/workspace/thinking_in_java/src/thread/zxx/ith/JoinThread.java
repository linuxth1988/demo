package thread.zxx.ith;

public class JoinThread
{
	public static void main(String[] args)
	{
		ThreadTest t = new ThreadTest();
		Thread pp = new Thread(t);
		pp.start();

		int i = 0;

		while (true)
		{
			if (i == 20)
			{
				try
				{
					pp.join();
				}
				catch (Exception e)
				{

				}
			}
			if(i == 111)
				System.exit(0);
				
			System.out.println("main Thread " + i++);
		}
	}
}

class ThreadTest implements Runnable
{
	@Override
	public void run()
	{
		int i = 0;
		while (i <= 50)
		{
			System.out.println(Thread.currentThread().getName() + "  " + i++);
		}
	}
}
