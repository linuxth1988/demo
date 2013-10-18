package org.ith.chapter8_interface;

public class Filter
{
	public String name()
	{
		return getClass().getSimpleName();
	}
	
	public Waveform process(Waveform input)
	{
		return input;
	}
}
