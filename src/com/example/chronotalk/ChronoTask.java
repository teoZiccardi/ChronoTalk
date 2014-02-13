package com.example.chronotalk;

import java.util.TimerTask;

import android.app.Activity;


public class ChronoTask extends TimerTask {
	
	private Activity mActivity;
	private static int counter = 0;
	
	public ChronoTask(Activity mact)
	{
	
		this.mActivity = mact;
	}

	@Override
	public void run() {		
		timer();		
	}

	private void timer() {

		// TODO Timer logic
		
		counter++;
			
		if (mActivity != null)
		{
			mActivity.runOnUiThread(Timer_Tick);
		}

	}

	
	private Runnable Timer_Tick = new Runnable() {
		public void run() {
		
			// TODO View Update Logic
			if (mActivity != null)
			{
				((MainActivity)mActivity).timeUpdate(00, 00, counter);
			}
	
		}
	};
	
	
}
