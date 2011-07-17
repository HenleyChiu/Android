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

public class SlimKickerActivity extends Activity implements View.OnClickListener {
	Button btn;
	@Override
	
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
	    final boolean customTitleSupported = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

		setContentView(R.layout.main);
		
		//set background of header
		
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

	    //set fonts of labels
		Integer[] ids = {R.id.points_label, R.id.badges_label, R.id.level_label, R.id.total_points, R.id.total_diet, R.id.total_exercise, R.id.total_challenges};
		
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
		
		txt = (TextView) findViewById(R.id.myTitle);
		txt.setTypeface(font);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.slimkicker_menu, menu);
	    return true;
	}
	
	public void onClick(View view) {
		updateTime();
	}
	
	private void updateTime() {
		btn.setText(new Date().toString());
	}
}