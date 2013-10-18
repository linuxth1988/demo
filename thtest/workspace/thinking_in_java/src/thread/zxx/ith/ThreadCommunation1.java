package thread.zxx.ith;

public class ThreadCommunation1
{
	public static void main(String[] args)
	{

	}
}

class MyConsumer implements Runnable
{
	@Override
	public void run()
	{

	}
}

class MyProductor implements Runnable
{
	@Override
	public void run()
	{
		while (true)
		{
			
		}
	}
}

class Common
{
	private String name = "ÁøÑÒ";
	private String sex = "Å®";

	public synchronized void setCommon(String name, String sex)
	{
		this.name = name;
		this.sex = sex;
	}

	public synchronized void get()
	{
		System.out.println(name + "-------> " + sex);
	}
}
