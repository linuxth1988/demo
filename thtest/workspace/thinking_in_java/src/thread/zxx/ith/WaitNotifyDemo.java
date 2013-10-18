package thread.zxx.ith;

public class WaitNotifyDemo
{
	public static void main(String[] args) throws Exception
	{
		Resource res = new Resource();

		TheProductor productor = new TheProductor(res);
		TheConsumer consumer = new TheConsumer(res);

		Thread t1 = new Thread(productor);
		Thread t2 = new Thread(consumer);

		t1.start();
		t2.start();

	}
}

class Resource
{
	String name;
	String sex;
	/**false表示没有数据供给消费者*/
	boolean flag;
}

class TheProductor implements Runnable
{
	private Resource res;

	public TheProductor(Resource res)
	{
		this.res = res;
	}
//try{ wait(); }catch(Exception e){}
	
	@Override public void run()
	{
		int count = 0;

		while (true)
		{
			synchronized (res)
			{
				if(res.flag)
				{
					//有数据了,生产者等着
					try{ res.wait(); }catch(Exception e){}
				}
				else
				{
					if (count == 0)
					{
						res.name = "中国";
						res.sex = "男";
					}
					else
					{
						res.name = "America";
						res.sex = "female";
					}
					
					res.flag = true;
					count = (++count) % 2;
					res.notify();
				}
			}
		}
	}
}

class TheConsumer implements Runnable
{
	Resource res;

	public TheConsumer(Resource res)
	{
		this.res = res;
	}

	@Override
	public void run()
	{
		while (true)
		{
			synchronized (res)
			{
				if(!res.flag)
					//没有数据消费者先等着.
					try{ res.wait(); }catch(Exception e){}
				else
				{
					System.out.println(res.name+"--------> " + res.sex);
					res.flag = false;
					//叫醒生产者
					res.notify();
				}
			}
		}
	}
}
