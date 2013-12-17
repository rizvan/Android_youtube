package com.rzn.epaper;

import android.os.Bundle;
import android.app.Activity;
import android.text.format.Time;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Epaper extends Activity implements OnClickListener {
Button vk,pr,kp,sv,uv,tv;
WebView wb ;
TextView text;

String URL,eName;final Time td = new Time(Time.getCurrentTimezone());
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_epaper);
		vk = (Button) findViewById(R.id.vk);
		vk.setOnClickListener(this);
		
		pr = (Button) findViewById(R.id.pr);
		pr.setOnClickListener(this);
		
		kp =(Button) findViewById(R.id.kp);
		kp.setOnClickListener(this);
		uv = (Button) findViewById(R.id.uv);
		uv.setOnClickListener(this);
		sv = (Button) findViewById(R.id.sv);
		sv.setOnClickListener(this);
		tv = (Button) findViewById(R.id.tv);
		tv.setOnClickListener(this);
		td.setToNow();
		
		
	
			
	
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.epaper, menu);
		return true;
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
 
        switch (item.getItemId())
        {
        case R.id.author:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
            Toast.makeText(Epaper.this, "Author is Rizvan Hawaldar", Toast.LENGTH_LONG).show();
            return true;
        case R.id.backmenu:
        	finish();
        case R.id.exit:
            System.exit(0);
            break;
        default:
            return super.onOptionsItemSelected(item);
        }    
		return false;	
    }    
	private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
            }
          
}
	 
	 @Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		//	Toast.makeText(getApplicationContext(), arg0.getId(), Toast.LENGTH_SHORT).show();
			switch (arg0.getId()) {
			case R.id.vk:
				URL="http://vijaykarnatakaepaper.com";
				eName="Vijaya Karnataka";
				break;
			case R.id.pr:
				URL="http://prajavaniepaper.com/svww_index1.php";
				eName="Prajavani";
				break;
			case R.id.kp:
				URL="http://archives.kannadaprabha.com/pdf/epaper.asp?pdfdate="+td.month+"/"+td.monthDay+"/"+td.year;
				eName="Kannada Prabha";
				break;
			case R.id.uv:
				URL="http://epaper.udayavani.com/Display.aspx?Pg=H&Edn=BN&DispDate="+td.month+"/"+td.monthDay+"/"+td.year;
				eName="Udayavani";
				break;
			case R.id.sv:
				URL="http://www.sanjevani.com/e_paper/img_index.htm";
				eName="Sanje vani";
			break;
			case R.id.tv:
				URL="http://timesofindia.indiatimes.com";
				eName="Times of India";
			break;
			default:
				URL="http://timesofindia.indiatimes.com";
				break;
			}
			//http://epaper.udayavani.com/Display.aspx?Pg=H&Edn=BN&DispDate=3/16/2013
			//http://www.sanjevani.com/e_paper/img_index.htm
	//	Toast.makeText(getApplicationContext(), URL+" today month "+td.month+" year "+td.year+" day "+td.monthDay, Toast.LENGTH_SHORT).show();	
		setContentView(R.layout.webview);	
		wb = (WebView) findViewById(R.id.webview);
		wb.loadUrl(URL);
		WebSettings webSettings = wb.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setBuiltInZoomControls(true);
		wb.setWebViewClient(new WebViewClient());
		text  =(TextView) findViewById(R.id.papertextPrint);
		text.setText(eName);
		Button back = (Button) findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();	
			}
		});
		
		}
	 public boolean onKeyDown(int keyCode, KeyEvent event) {
         if ((keyCode == KeyEvent.KEYCODE_BACK)) {
             finish();
             return true;
         }
         return super.onKeyDown(keyCode, event);
     }
}