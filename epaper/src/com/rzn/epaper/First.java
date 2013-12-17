package com.rzn.epaper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class First extends Activity {
	Button home;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.first);
			home = (Button) findViewById(R.id.kep);
			home.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
				Intent i = new Intent(First.this, Epaper.class);
				startActivity(i);
				}
			});
		}		
}
