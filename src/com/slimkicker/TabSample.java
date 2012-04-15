package com.slimkicker;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.view.*;
import android.text.*;
import android.widget.*;
import android.graphics.Color;
import android.graphics.Typeface;

/**
 * @author www.androidcookers.co.cc
 * {@link www.androidcookers.co.cc}
 *
 */
public class TabSample extends TabActivity {
	/** Called when the activity is first created. */	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    final boolean customTitleSupported = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

		setContentView(R.layout.main);
		
		ViewGroup decorView = (ViewGroup) this.getWindow().getDecorView();
		 
	    LinearLayout root = (LinearLayout) decorView.getChildAt(0);
	    FrameLayout titleContainer = (FrameLayout) root.getChildAt(0);
	    titleContainer.setBackgroundColor(Color.parseColor("#1E8FEB"));
	
		decorView.setPadding(0, 0, 0, 0);
	    //set custom title header
		
	    if (customTitleSupported ) {
	    		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.mytitle);
        }
		
	    final TextView myTitleText = (TextView) findViewById(R.id.myTitle);
	    if ( myTitleText != null ) {
			Typeface font = Typeface.createFromAsset(getAssets(), "helvet-lt-webfont.ttf");
			myTitleText.setTypeface(font);
			
	        //myTitleText.setText("Welcome to SlimKicker");
	        //myTitleText.setBackgroundColor(Color.GREEN);
	    }
	    
		setTabs() ;
	}
	private void setTabs()
	{
		addTab("Home", R.drawable.tab_home,SlimKickerActivity.class);
		addTab("Diet", R.drawable.tab_search, OptionsActivity.class);
		addTab("Body", R.drawable.tab_search, OptionsActivity.class);
		addTab("Challenges", R.drawable.tab_search, OptionsActivity.class);
		addTab("Friends", R.drawable.tab_search, OptionsActivity.class);
		//To add more tabs just use addTab() method here like previous line.
	}
	
	private void addTab(String labelId, int drawableId, Class<?> c)
	{
		TabHost tabHost = getTabHost();
		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);	
		
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
		title.setText(labelId);
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);
		
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}
}