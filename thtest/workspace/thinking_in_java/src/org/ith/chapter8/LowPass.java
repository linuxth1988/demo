package org.ith.chapter8;

public class LowPass extends Filter
{
	double cutoff;
	public LowPass(double cutoff)
	{
		this.cutoff = cutoff;
	}
	
	public Waveform process(Waveform input)
	{
		return input;
	}
}
