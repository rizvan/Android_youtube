package com.jd.video.search;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.jd.video.search.R;

public class VideoActivity extends FragmentActivity {

	private int REQ_PLAYER_CODE 	= 1;
	private static String YT_KEY 	= "API_KEY_HERE";
	private static String VIDEO_ID 	= "US4-yIy5BY4";	// Your video id here
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		if(YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(VideoActivity.this).equals(YouTubeInitializationResult.SUCCESS)){
			   //This means that your device has the Youtube API Service (the app) and you are safe to launch it. 
			final Intent videoIntent = YouTubeStandalonePlayer.createVideoIntent(VideoActivity.this, YT_KEY, VIDEO_ID, 0, true, false);
			startActivity(videoIntent);	
			}else{
			   // Log the outcome, take necessary measure, like playing the video in webview :)  
				Log.d("LAUNCH YOUTUBE", "1");
			}
	}

//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		super.onActivityResult(requestCode, resultCode, data);
//		if ( resultCode != RESULT_OK) {
//			YouTubeInitializationResult errorReason = YouTubeStandalonePlayer.getReturnedInitializationResult(data);
//			if (errorReason.isUserRecoverableError()) {
//				errorReason.getErrorDialog(this, 0).show();
//			} else {
//				String errorMessage = String.format("PLAYER ERROR!!", errorReason.toString());
//				Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
//			}
//		}
//	}
}
