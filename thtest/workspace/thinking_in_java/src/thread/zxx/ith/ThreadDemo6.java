package thread.zxx.ith;

/*
 * ��֤ͬ��������ͬ������this
 */
public class ThreadDemo6
{
	public static void main(String[] args)
	{
		MyRunnable t = new MyRunnable();
		
		// ����̵߳���ͬ�������
		Thread t1 = new Thread(t, "������߳�");
		t1.start();
		
//		try{Thread.sleep(20);}catch(Exception e){}
		
		 t.str = new String("method");
		 //����ͬ������
		 Thread t2 = new Thread(t,"ͬ�������߳�");
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
			 * ��ӡ��ticket0���߸�Сʱ˵���߳��ǲ�ͬ����, ����thisû���������,Ҳ��˵ͬ��������ͬ������ͬ����,
			 * �Ӷ�֤��ͬ��������ͬ����ȷʵ��this
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

					System.out.println("\tͬ�������   \t" + Thread.currentThread().getName() + " is saling ticket "+ tickets--);
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

			System.out.println("ͬ������\t" + Thread.currentThread().getName() + " is saling ticket " + tickets--);
		}
	}
}
