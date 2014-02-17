package com.example.chronotalk.voice;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;





public class VoiceController implements RecognitionListener{
	
	private final static String TAG = "VoiceController";
	
	
	public static interface VoiceListener
	{
		public void onDbChanged(float value);
	}
	
	
	
	private Context mContext;
	
	private SpeechRecognizer mSpeechRecognizer;
	private Intent mSpeechRecognizerIntent;
	private VoiceListener mVoiceListener;
	private boolean listening;
	
	public VoiceController (final Context ctx)
	{
		this.mContext = ctx;
		
		listening = false;
		
	}
	
	public void setVoiceListener (final VoiceListener listener)
	{
		this.mVoiceListener = listener;
	}
	
	public void startVoiceRecgnition ()
	
	{

	
		
		if (!listening)
		{
			listening = true;
			mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(mContext);
			mSpeechRecognizer.setRecognitionListener(this);
			mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
			mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
					RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
			mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
					mContext.getPackageName());
			mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
			Log.d(TAG," SpeechRecognizer Listening");
		}
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

	@Override
	public void onEndOfSpeech() {
		// TODO Auto-generated method stub
		listening = false;				
	}

	@Override
	public void onRmsChanged(float value) {
		// TODO Auto-generated method stub
		Log.d(TAG,"Rms Value "+value);
		if (mVoiceListener != null)
			mVoiceListener.onDbChanged(value);
		
	}

	@Override
	public void onBeginningOfSpeech() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBufferReceived(byte[] buffer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(int error) {
		// TODO Auto-generated method stub
		listening = false;	
		
	}

	@Override
	public void onEvent(int eventType, Bundle params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPartialResults(Bundle partialResults) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReadyForSpeech(Bundle params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onResults(Bundle results) {
		// TODO Auto-generated method stub
		
	}

	

}
