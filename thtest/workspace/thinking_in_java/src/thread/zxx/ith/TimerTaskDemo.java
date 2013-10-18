package thread.zxx.ith;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskDemo
{
	static int countt = 0;
	static int time = 0;

	public static void main(String[] args)
	{
		int count = 0;

		for (int i = 0; i < 10; i++)
		{
			System.out.println("i = " + i + ", count = " + count);
			count = (count + 1) % 2;
		}

		final Timer tm = new Timer();
		
		final int[] tcount = new int[2];
		
		class MyTask extends TimerTask
		{
			@Override
			public void run()
			{
				tcount[0] = tcount[1] == 0 ? 2000 : 4000;
				tcount[1] = (tcount[1] + 1) % 2;
				tm.schedule(new MyTask(), tcount[0]);
				
				System.out.println("execute  method");
			}
		}

		tm.schedule(new MyTask(), 2000);

		while (true)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (Exception e)
			{
			}

			java.util.Date now = new java.util.Date();
			System.err.println(now.getSeconds());
		}

	}
}
