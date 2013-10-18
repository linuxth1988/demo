package org.ith.t2013523;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;


public class AnonymousInnerClassTest
{
	public static void main(String[] args)
	{
		TalkingClock clock = new TalkingClock();
		clock.start(100, true);
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TalkingClock
{
	public void start(int interval,final boolean beep)
	{
		ActionListener listener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Date now = new Date();
				System.out.println("at the tone,the time is "+ now);
				if(beep)Toolkit.getDefaultToolkit().beep();
			}
		};
		
		Timer t = new Timer(interval,listener);
		t.start();
	}
}