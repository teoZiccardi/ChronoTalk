package com.example.chronotalk.fragments;

import com.example.chronotalk.R;
import com.example.chronotalk.Util.Utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainFragment extends Fragment{
	
	private TextView minute,seconds,cents;
	private ImageView mic;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
		minute = (TextView) rootView.findViewById(R.id.minute);
        seconds = (TextView) rootView.findViewById(R.id.seconds);
        cents = (TextView) rootView.findViewById(R.id.cents);
        mic = (ImageView)rootView.findViewById(R.id.voiceImage);
            
        return rootView;
	}
	

	public void updateUi (final int min,final int sec,final int cent)
	{
		
		minute.setText(Utils.stringTime(min));
		seconds.setText(Utils.stringTime(sec));
		cents.setText(Utils.stringTime(cent));		
		
	}
	
	
	public void animateMicImage (float value)
	{
		
		// TODO
		
	}
	

}
