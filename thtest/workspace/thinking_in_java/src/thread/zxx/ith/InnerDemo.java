package thread.zxx.ith;

public class InnerDemo
{
	public static void main(String[] args)
	{
		/*
		Outer out = new Outer();
		此处编译会报错. 你知道内部类能够访问外部类的实例
		在一个外部类的静态方法中不能new内部类的实例对象.
		内部类是可以访问外部类的成员变量的这个你知道.而成员变量是对象相关的.
		也就是说要现有实例才能有成员变量.如果外部类的静态方法能够new出内部类的对象了.
		那如果这个内部类的对象要访问外部类的属性呢? 注意当外部类的静态方法是类相关的,也就是说
		就算没有外部类实例也可以有静态方法.那么内部类又要访问外部类的属性,访问外部类的属性必须
		是外部类的实例存在.这就矛盾了.所以在外部类的静态方法中不能new出内部类的实例对象.
		
		解决的办法就是把原来在静态方法中要执行的代码封装到一个外部类的实例方法中.
		再在该静态方法中调用该外部类的实例方法即可.
		*
		*/
		while(true)
		new InnerDemo().init();
	}
	
	void init()
	{
		final MyOutter out = new MyOutter();
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try{Thread.sleep(10);}catch(Exception e){}
				out.printf("tangxiansheng");
			}
		}).start();
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try{Thread.sleep(10);}catch(Exception e){}
				out.printf("what's_app");
			}
		}).start();
	}

	class MyOutter
	{
		void printf(String name)
		{
			int length = name.length();
			for (int i = 0; i < length; i++)
				System.out.print(name.charAt(i));
			System.out.println();
		}
	}
}
