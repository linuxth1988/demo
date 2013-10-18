package thread.zxx.ith;
/*
t0,t1生产线程,t2,t3消费线程

1 假设t0先获取CPU执行权正常生产后打印,此时flag被置为true
  t0生产者-------0

2 然后还有执行权则会再次进入if判断 t0会停在wait()处
    假设此时又一个生产线程t1获取执行权,因为此时flag为true,
  t1则直接停在wait()处.

3 消费线程t2获取CPU执行权,正常消费把flag置为false,正常打印.
  t2消费者+++++++0  
     如果它还持有CPU执行权,会再次进入if判断 停在wait()处(此时flag为false)
  
4 现在只剩下一个消费线程t3,直接进入因为flag是false,直接停在wait处,
  此时,所有的线程都在等待唤醒.注意这不是死锁,死锁是你向我要,我向你要
  
   t0   t1   t2  t3
   
   t0生产者-------0
   t2消费者+++++++0  
 */
 
public class UseNotifyAll
{
	public static void main(String[] args)
	{
		MyRes res = new MyRes();
		
		new Thread(new ThProducotr(res)).start();
		new Thread(new ThProducotr(res)).start();
		new Thread(new ThConsumer(res)).start();
		new Thread(new ThConsumer(res)).start();
	}
}


class MyRes
{
	String name;
	int number;
	boolean flag;

	public synchronized void set(String name)
	{
//		if(flag)
		while (flag)
		{
			try{this.wait();}catch (Exception e){}
		}
//		else
		{
			this.name = name + number++;
			flag = true;
//			notify();
			//Wakes up all threads that are waiting on this object's monitor.
			notifyAll();
			System.out.println(Thread.currentThread().getName()+"生产者---> " + this.name);
		}
	}

	public synchronized void get()
	{
//		if (!flag)
		while(!flag)
		{
			try{this.wait();}catch (Exception e){}
		}
//		else
		{
			System.out.println(Thread.currentThread().getName() + "-消费者+++++++++++> " + name);
			flag = false;
//			notify();
			notifyAll();
		}
	}
}


class ThProducotr implements Runnable
{
	private MyRes res;
	
	public ThProducotr(MyRes res)
	{
		this.res = res;
	}
	
	@Override public void run()
	{
		while(true)
		{
			res.set("mac_book_pro\t");
		}
	}
}

class ThConsumer implements Runnable
{
	private MyRes res;
	
	public ThConsumer(MyRes res)
	{
		this.res = res;
	}

	@Override public void run()
	{
		while(true)
		{
			res.get();
		}
	}
}
