package thread.zxx.ith;

public class InnerDemo
{
	public static void main(String[] args)
	{
		/*
		Outer out = new Outer();
		�˴�����ᱨ��. ��֪���ڲ����ܹ������ⲿ���ʵ��
		��һ���ⲿ��ľ�̬�����в���new�ڲ����ʵ������.
		�ڲ����ǿ��Է����ⲿ��ĳ�Ա�����������֪��.����Ա�����Ƕ�����ص�.
		Ҳ����˵Ҫ����ʵ�������г�Ա����.����ⲿ��ľ�̬�����ܹ�new���ڲ���Ķ�����.
		���������ڲ���Ķ���Ҫ�����ⲿ���������? ע�⵱�ⲿ��ľ�̬����������ص�,Ҳ����˵
		����û���ⲿ��ʵ��Ҳ�����о�̬����.��ô�ڲ�����Ҫ�����ⲿ�������,�����ⲿ������Ա���
		���ⲿ���ʵ������.���ì����.�������ⲿ��ľ�̬�����в���new���ڲ����ʵ������.
		
		����İ취���ǰ�ԭ���ھ�̬������Ҫִ�еĴ����װ��һ���ⲿ���ʵ��������.
		���ڸþ�̬�����е��ø��ⲿ���ʵ����������.
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
