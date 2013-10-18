package thread.zxx.ith;

/*
误区一：认为returnThreadInfo对象中的run方法一定在主类的System.out.println(returnThreadInfo.getThreadInfo())之前运行。
这是比较常见的一个误区，稍微了解一些java编译原理的人应该清楚，java源文件的代码编译是自上而下的，也就是处在同一文件上面的代
码会在下面的代码之间被编译和运行。所以很多人认为returnThreadInfo.start()先被运行，returnThreadInfo线程被启动，然后run()方法被
调用，str被赋值："hello world!"，然后线程结束并返回到主类，最后调用System.out.println(returnThreadInfo.getThreadInfo())将str
的值输出就是"Hello world!"。
   如果returnThreadInfo不是一个线程而是一个普通类的对象，那么输出的结果是"Hello world"，但是正因为returnThreadInfo是一个线程
，所以run方法并不一定在System.out.println(returnThreadInfo.getThreadInfo())之前运行。因为实际上主类Main在运行时也是一个线程，
当调用returnThreadInfo.start()方法来启动returnThreadInfo线程后，此时系统中运行的实际上就是Main和returnThreadInfo两个线程，那
么这两个线程就会竞争CPU，谁先抢到CPU的控制权，谁就会先运行（实际上线程谁能优先抢到CPU运行时间是靠优先级来决定的，优先级可以通
过线程的setPriority(int newPriority)来设置，newPriority的取值是1-10,newPriority值越大，线程的优先级就越高，优先强占CPU的几率
就越大。线程默认的优先级是5）。由于Main和returnThreadInfo的优先级都默认为5，所以它们争抢CPU的几率是相同的。又因为Main线程实际
上是比returnThreadInfo线程先启动的，所以在这个程序中，Main的System.out.println(returnThreadInfo.getThreadInfo())反而比
returnThreadInfo的run方法更早运行，所以输出的str值还是初始的"Hello"。
 */
public class ThreadDDemo  extends Thread
{
	public ThreadDDemo()
	{
	}

	public static void main(String[] args)throws Exception
	{
		ReturnThreadInfo info = new ReturnThreadInfo();
		info.start();
		Thread.sleep(1);
		System.out.println(info.getThreadInfo());
	}
}

class ReturnThreadInfo extends Thread
{
	private String str;

	public ReturnThreadInfo()
	{
		this.str = "Hello";
	}

	public void run()
	{
		try
		{
			this.str = "Hello world";
		}
		catch (Exception e)
		{
		}
	}

	public String getThreadInfo()
	{
		return this.str;
	}
}