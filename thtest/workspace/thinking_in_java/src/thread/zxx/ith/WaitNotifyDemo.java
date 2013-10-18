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
	/**false��ʾû�����ݹ���������*/
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
					//��������,�����ߵ���
					try{ res.wait(); }catch(Exception e){}
				}
				else
				{
					if (count == 0)
					{
						res.name = "�й�";
						res.sex = "��";
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
					//û�������������ȵ���.
					try{ res.wait(); }catch(Exception e){}
				else
				{
					System.out.println(res.name+"--------> " + res.sex);
					res.flag = false;
					//����������
					res.notify();
				}
			}
		}
	}
}
