package org.ith.t2013513;

class Building
{

}

class Hose extends Building
{
	
}
/**
 
*/
	

public class ClassTypeCapture<T>
{
	Class<T> kind;
	
	public ClassTypeCapture(Class<T> kind)
	{
		this.kind = kind;
	}
	
	public boolean f(Object arg)
	{
		return kind.isInstance(arg);
	}
	
	public static void main(String[] args)
	{
		ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new Hose()));
		
		System.out.println("----------------");
		
		ClassTypeCapture<Hose> ctt2 = new ClassTypeCapture<Hose>(Hose.class);
		System.out.println(ctt2.f(new Building()));
		System.out.println(ctt2.f(new Hose()));
		
	}
}
