package com.example.chronotalk;

import com.example.chronotalk.voice.VoiceController;
import com.example.chronotalk.voice.VoiceController.VoiceListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;


public class ButtonController extends FragmentActivity{
	
	private final static String TAG = "ButtonController";
	
	private VoiceController mVoiceController;
	
	

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		mVoiceController = new VoiceController(getApplicationContext());
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mVoiceController.onDestroy();	
		mVoiceController = null;
	}

	
	public VoiceController getVoiceController()
	{
		return this.mVoiceController;
	}
	
	public void setVoiceListener (VoiceListener mListener)
	{
		this.mVoiceController.setVoiceListener(mListener);
	}
	
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		Log.d(TAG,"Key "+keyCode);
		if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)
		{
			if (mVoiceController != null)
				mVoiceController.startVoiceRecgnition();
			
				
		}
		return super.onKeyUp(keyCode, event);
	}
	
	
	

}
