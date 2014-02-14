package com.example.chronotalk.Util;

public class Utils {
	
	public static String getFragmentName(final int viewId, final int index) {
	     return "android:switcher:" + viewId + ":" + index;
	}
	
	
	public static String stringTime (final int time)
	{
		final String temp = String.valueOf(time);
		return (time>=10)?temp:"0"+temp;
	}

}
