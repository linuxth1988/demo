package thread.zxx.ith;
/**
据说根据面向对象的精神,写线程的方式推荐用Runnable,
 因为这样显得更OOP,new Thread(new Runnable()).start();
new出来一个Thread对象,用执行的内容又封装到一个Runnable中

形如这样的代码:
new Thread
  (
    new Runnable
    (
    	public void run()
    	{
    		System.out.println("实现Runnable方式");
    	}
    )
  )
  {
  	public void run()
  	{
  		System.out.println("匿名内部类Thread的子类方法");
  	}
  }.start();

应该执行的是匿名内部类Thread的方法,相当于有子类了就先找子类的,
没有子类才去找父类的runnable.
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
