package thread.zxx.ith;
/*
t0,t1�����߳�,t2,t3�����߳�

1 ����t0�Ȼ�ȡCPUִ��Ȩ�����������ӡ,��ʱflag����Ϊtrue
  t0������-------0

2 Ȼ����ִ��Ȩ����ٴν���if�ж� t0��ͣ��wait()��
    �����ʱ��һ�������߳�t1��ȡִ��Ȩ,��Ϊ��ʱflagΪtrue,
  t1��ֱ��ͣ��wait()��.

3 �����߳�t2��ȡCPUִ��Ȩ,�������Ѱ�flag��Ϊfalse,������ӡ.
  t2������+++++++0  
     �����������CPUִ��Ȩ,���ٴν���if�ж� ͣ��wait()��(��ʱflagΪfalse)
  
4 ����ֻʣ��һ�������߳�t3,ֱ�ӽ�����Ϊflag��false,ֱ��ͣ��wait��,
  ��ʱ,���е��̶߳��ڵȴ�����.ע���ⲻ������,������������Ҫ,������Ҫ
  
   t0   t1   t2  t3
   
   t0������-------0
   t2������+++++++0  
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
			System.out.println(Thread.currentThread().getName()+"������---> " + this.name);
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
			System.out.println(Thread.currentThread().getName() + "-������+++++++++++> " + name);
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
