package thread.zxx.ith;

/*
 * 验证同步代码块的同步锁是this
 */
public class ThreadDemo6
{
	public static void main(String[] args)
	{
		MyRunnable t = new MyRunnable();
		
		// 这个线程调用同步代码块
		Thread t1 = new Thread(t, "代码块线程");
		t1.start();
		
//		try{Thread.sleep(20);}catch(Exception e){}
		
		 t.str = new String("method");
		 //调用同步函数
		 Thread t2 = new Thread(t,"同步方法线程");
		 t2.start();
	}
}

class MyRunnable implements Runnable
{
	private int tickets = 100;

	String str = "";

	@Override
	public void run()
	{
		if (str.equals("method"))
		{
				sale();
		}
		else
		{
			/*
			 * 打印出ticket0或者更小时说明线程是不同步的, 换成this没有上述情况,也就说同步代码块和同步函数同步了,
			 * 从而证明同步代码块的同步锁确实是this
			 */
			synchronized (this) // synchronized (this)
			{
				while (tickets > 0)
				{
					try
					{
						Thread.sleep(10);
					}
					catch (Exception e)
					{
						System.out.println(e.getMessage());
					}

					System.out.println("\t同步代码块   \t" + Thread.currentThread().getName() + " is saling ticket "+ tickets--);
				}
			}
		}
	}

	public synchronized void sale()
	{
		while (tickets > 0)
		{
			try
			{
				Thread.sleep(10);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}

			System.out.println("同步函数\t" + Thread.currentThread().getName() + " is saling ticket " + tickets--);
		}
	}
}
