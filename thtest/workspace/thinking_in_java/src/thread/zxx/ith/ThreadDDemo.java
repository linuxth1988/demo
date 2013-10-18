package thread.zxx.ith;

/*
����һ����ΪreturnThreadInfo�����е�run����һ���������System.out.println(returnThreadInfo.getThreadInfo())֮ǰ���С�
���ǱȽϳ�����һ����������΢�˽�һЩjava����ԭ�����Ӧ�������javaԴ�ļ��Ĵ�����������϶��µģ�Ҳ���Ǵ���ͬһ�ļ�����Ĵ�
���������Ĵ���֮�䱻��������С����Ժܶ�����ΪreturnThreadInfo.start()�ȱ����У�returnThreadInfo�̱߳�������Ȼ��run()������
���ã�str����ֵ��"hello world!"��Ȼ���߳̽��������ص����࣬������System.out.println(returnThreadInfo.getThreadInfo())��str
��ֵ�������"Hello world!"��
   ���returnThreadInfo����һ���̶߳���һ����ͨ��Ķ�����ô����Ľ����"Hello world"����������ΪreturnThreadInfo��һ���߳�
������run��������һ����System.out.println(returnThreadInfo.getThreadInfo())֮ǰ���С���Ϊʵ��������Main������ʱҲ��һ���̣߳�
������returnThreadInfo.start()����������returnThreadInfo�̺߳󣬴�ʱϵͳ�����е�ʵ���Ͼ���Main��returnThreadInfo�����̣߳���
ô�������߳̾ͻᾺ��CPU��˭������CPU�Ŀ���Ȩ��˭�ͻ������У�ʵ�����߳�˭����������CPU����ʱ���ǿ����ȼ��������ģ����ȼ�����ͨ
���̵߳�setPriority(int newPriority)�����ã�newPriority��ȡֵ��1-10,newPriorityֵԽ���̵߳����ȼ���Խ�ߣ�����ǿռCPU�ļ���
��Խ���߳�Ĭ�ϵ����ȼ���5��������Main��returnThreadInfo�����ȼ���Ĭ��Ϊ5��������������CPU�ļ�������ͬ�ġ�����ΪMain�߳�ʵ��
���Ǳ�returnThreadInfo�߳��������ģ���������������У�Main��System.out.println(returnThreadInfo.getThreadInfo())������
returnThreadInfo��run�����������У����������strֵ���ǳ�ʼ��"Hello"��
 */
public class ThreadDDemo  extends Thread
{
	public ThreadDDemo()
	{
	}

	public static void main(String[] args)throws Exception
	{
		ReturnThreadInfo info = new ReturnThreadInfo();
		info.start();
		Thread.sleep(1);
		System.out.println(info.getThreadInfo());
	}
}

class ReturnThreadInfo extends Thread
{
	private String str;

	public ReturnThreadInfo()
	{
		this.str = "Hello";
	}

	public void run()
	{
		try
		{
			this.str = "Hello world";
		}
		catch (Exception e)
		{
		}
	}

	public String getThreadInfo()
	{
		return this.str;
	}
}