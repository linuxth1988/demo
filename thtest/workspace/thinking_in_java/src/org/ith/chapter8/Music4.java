package org.ith.chapter8;


abstract class Instrument
{
	private int i; //storage allocated for each
	
	public abstract void play(Note n);
	
	public String what()
	{
		return "Instrument";
	}
	
	public abstract void adjust();
}


public class Music4
{

}
