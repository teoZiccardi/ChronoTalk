package com.example.chronotalk.fragments;

import com.example.chronotalk.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment{
	
	private TextView minute,seconds,cents;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
     
        return rootView;
	}


	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		minute = (TextView) view.findViewById(R.id.minute);
        seconds = (TextView) view.findViewById(R.id.seconds);
        cents = (TextView) view.findViewById(R.id.cents);
	}
	
	


	public void updateUi (int min,int sec,int cent)
	{
		minute.setText(min);
		seconds.setText(sec);
		cents.setText(cent);
	}
	

}
