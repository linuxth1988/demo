package thread.zxx.ith;
/**
��˵�����������ľ���,д�̵߳ķ�ʽ�Ƽ���Runnable,
 ��Ϊ�����Եø�OOP,new Thread(new Runnable()).start();
new����һ��Thread����,��ִ�е������ַ�װ��һ��Runnable��

���������Ĵ���:
new Thread
  (
    new Runnable
    (
    	public void run()
    	{
    		System.out.println("ʵ��Runnable��ʽ");
    	}
    )
  )
  {
  	public void run()
  	{
  		System.out.println("�����ڲ���Thread�����෽��");
  	}
  }.start();

Ӧ��ִ�е��������ڲ���Thread�ķ���,�൱���������˾����������,
û�������ȥ�Ҹ����runnable.
 */
public class FirstThread
{
	public static void main(String[] args)throws Exception
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println(Thread.currentThread().getName()+" aaaaaaaa");
			}
		}).start();
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("the runnable");
			}
		})
		{
			@Override public void run()
			{
				System.out.println("the thread   bbbbbbbbbbbbbb");
			}
		}.start();
	}
}
