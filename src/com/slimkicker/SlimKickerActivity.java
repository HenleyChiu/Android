package com.slimkicker;

import android.app.Activity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Date;
import android.widget.TextView;
import android.graphics.Typeface;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.Window;
import android.graphics.Color;
import android.view.*;
import android.text.*;
import android.widget.*;
import android.content.*;

public class SlimKickerActivity extends Activity {
	 public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle item selection
	        switch (item.getItemId()) {
	        case R.id.home_option:
	            return true;
	        case R.id.diet_option:
	            Intent intent = new Intent(this, DietActivity.class);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }

	public void onCreate(Bundle icicle) {
		//getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		
		super.onCreate(icicle);
	    //final boolean customTitleSupported = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

		setContentView(R.layout.profile);
		
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);

		//set background of header
		/*
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
	    }
		
		*/
		
	    //set fonts of labels
		Integer[] ids = {R.id.points_label, R.id.badges_label, R.id.level_label, 
				
				R.id.points_amount, R.id.badges_amount, R.id.level_amount,
				R.id.total_points, R.id.total_diet, R.id.total_exercise, R.id.total_challenges};
		
		for(int i=0; i< ids.length; i++){
			int id = ids[i];
			TextView txt = (TextView) findViewById(id);
			Typeface font = Typeface.createFromAsset(getAssets(), "museo700regular.ttf");
			txt.setTypeface(font);
		}
		
		TextView txt = (TextView) findViewById(R.id.daily_summary_label);
		Typeface font = Typeface.createFromAsset(getAssets(), "helvet-lt-webfont.ttf");
		txt.setTypeface(font);
		
		txt = (TextView) findViewById(R.id.leaderboard_label);
		txt.setTypeface(font);
		
		txt = (TextView) findViewById(R.id.this_week_label);
		txt.setTypeface(font);
		

	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.slimkicker_menu, menu);
	    return true;
	}

		
}