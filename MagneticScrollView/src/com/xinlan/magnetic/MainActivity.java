package com.xinlan.magnetic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class MainActivity extends Activity {
	private ScrollView scrollView;
	private View magView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		scrollView =(ScrollView)findViewById(R.id.scroll);
		magView = findViewById(R.id.mag);
	}
	
	
}//end class
