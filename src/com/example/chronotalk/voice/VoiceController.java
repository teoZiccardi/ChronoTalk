package com.example.chronotalk.voice;

import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;





public class VoiceController{
	
	private final static String TAG = "VoiceController";
	
	private Context mContext;
	
	private SpeechRecognizer mSpeechRecognizer;
	private Intent mSpeechRecognizerIntent;
	private SpeechListener mSpeechListener;
	
	public VoiceController (final Context ctx)
	{
		this.mContext = ctx;
		
	}
	
	public void startVoiceRecgnition ()
	
	{
		
		if (mSpeechListener == null) mSpeechListener = new SpeechListener();
		
		
		mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(mContext);
		mSpeechRecognizer.setRecognitionListener(mSpeechListener);
	    mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	    mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
	                                     RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	    mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
	                                     mContext.getPackageName());
	    mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
	}
	
	public void stopVoiceRecognition()
	{
		mSpeechRecognizer.stopListening();
	}
	
	public void onDestroy ()
	
	{
		mSpeechRecognizer.destroy();
		mSpeechRecognizer = null;
	}

	

}
