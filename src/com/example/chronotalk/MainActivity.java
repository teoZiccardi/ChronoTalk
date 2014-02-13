package com.example.chronotalk;



import java.util.Timer;

import com.example.chronotalk.fragments.DetailFragment;
import com.example.chronotalk.fragments.MainFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;



public class MainActivity extends FragmentActivity {

	private final static String TAG = "MainActivity";

	private static final int numberOfSections = 2;

	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Log.d(TAG,"Called getItem");
			switch (position)
			{
			case 0:
				return new MainFragment();           	
			case 1:
				return new DetailFragment();         	
			default:
				return null;           	
			}            
		}

		@Override
		public int getCount() {           
			return numberOfSections;
		}


	}


	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;
	
	private Timer mTimer;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		


		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		mTimer = new Timer();

	}

	
	
	public void start(View v)
	{
		if (mTimer != null)
		{
			mTimer.schedule(new ChronoTask(this),0,10);
		}
		
	}

	public void stop(View v)
	{
		if (mTimer != null)
		{
			mTimer.cancel();
		}
	}
	
	public void timeUpdate(int min,int sec,int cent)
	{
		if (mViewPager.getCurrentItem() == 0)
		{
			((MainFragment)mSectionsPagerAdapter.getItem(0)).updateUi(min, sec, cent);
		}
		
	}



}
