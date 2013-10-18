package thread.zxx.ith;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo
{
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();

		try
		{
			ArrayList<Future<String>> results = new ArrayList<Future<String>>();

			for (int i = 0; i < 10; i++)
				results.add(exec.submit(new ThreadWithResult(i)));

			for (Future<String> fu : results)
			{
				try
				{
					System.out.println(fu.get());
				}
				catch (ExecutionException e)
				{
					e.printStackTrace();
				}
			}
		}
		catch (InterruptedException e)
		{
		}
		finally
		{
			exec.shutdown();
		}
	}
}

class ThreadWithResult implements Callable<String>
{
	private int id;

	public ThreadWithResult(int id)
	{
		this.id = id;
	}

	@Override
	public String call()
	{
		return "the result is : " + id;
	}

}