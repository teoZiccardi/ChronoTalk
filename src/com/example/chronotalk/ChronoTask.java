package com.example.chronotalk;

import java.util.TimerTask;

import android.app.Activity;


public class ChronoTask extends TimerTask {

	private Activity mActivity;
	private static int counter = 0;
	private int min,sec,cent;



	public ChronoTask(Activity mact)
	{

		this.mActivity = mact;
	}

	@Override
	public void run() {		
		timer();		
	}

	private void timer() {

		// Timer logic

		counter++;

		min = counter/6000;
		sec = (counter%6000)/100;
		cent = ((counter%100000)%1000)%100;



		if (mActivity != null)
		{
			mActivity.runOnUiThread(Timer_Tick);
		}

	}


	private final Runnable Timer_Tick = new Runnable() {
		public void run() {

			// View Update Logic
			if (mActivity != null)
			{
				((MainActivity)mActivity).timeUpdate(min, sec, cent);
			}

		}
	};


}
