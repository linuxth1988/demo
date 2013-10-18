package org.ith.t2013509;


public class Test1
{
	public static void main(String[] args)
	{
		ClassLoader dogloader = new Dog().getClass().getClassLoader();
		ClassLoader pigloader = new Pig().getClass().getClassLoader();
		ClassLoader Birdloader = new Pig().getClass().getClassLoader();
		
		System.out.println("dogloader" + dogloader);
		System.out.println("pigloader" + pigloader);
		System.out.println("Birdloader" + Birdloader);
		
		System.out.println(dogloader == pigloader);
		
		System.out.println(dogloader.equals(pigloader));
	}
}


class Animal
{
	public Animal()
	{
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
}

class Dog extends Animal
{
	
}

class Pig extends Animal
{
	
}

class Bird extends Animal
{
	
}