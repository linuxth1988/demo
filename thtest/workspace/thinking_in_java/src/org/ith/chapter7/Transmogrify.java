package org.ith.chapter7;

public class Transmogrify
{
	public static void main(String[] args)
	{
		Stage st = new Stage();

		st.performPlay();

		st.change();

		st.performPlay();
	}
}

class Actor
{
	public void act()
	{
	}
}

class HappyActor extends Actor
{
	@Override
	public void act()
	{
		System.out.println("happyActor");
	}
}

class SadActor extends Actor
{
	@Override
	public void act()
	{
		System.out.println("SadActor");
	}
}

class Stage
{
	private Actor actor = new HappyActor();

	public void change()
	{
		actor = new SadActor();
	}

	public void performPlay()
	{
		actor.act();
	}
}
