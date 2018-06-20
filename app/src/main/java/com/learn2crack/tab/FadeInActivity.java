package com.learn2crack.tab;



import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FadeInActivity extends Activity implements AnimationListener {

	TextView txtMessage;
	Button btnStart;
	ImageView img;
	// Animation
	Animation animFadein;
	ImageView imgPoster;
	Animation animBounce;
	int milliseconds;
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fadein);
		actionBar = getActionBar();
		actionBar.hide();

		//txtMessage = (TextView) findViewById(R.id.txtMessage);
	//	btnStart = (Button) findViewById(R.id.btnStart);
		img = (ImageView) findViewById(R.id.camicon);
		imgPoster = (ImageView) findViewById(R.id.imgLogo);

		// load the animation
		img.setVisibility(View.VISIBLE);
		animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.fade_in);
		 animBounce = AnimationUtils.loadAnimation(getApplicationContext(),
					R.anim.bounce);

			// set animation listener
			animBounce.setAnimationListener(this);
		
		// set animation listener
		animFadein.setAnimationListener(this);
		img.startAnimation(animFadein);
		try{
			

			final Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
			  @Override
			  public void run() {
			    //Do something after 100ms
				 
					imgPoster.setVisibility(View.VISIBLE);
					imgPoster.startAnimation(animBounce);
			  }
			}, 2000);
			
			
			// start the animation
			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		finally
		{
				
		}
				
		
					
	}
		



	@Override
	public void onAnimationEnd(Animation animation) {
		// Take any action after completing the animation

		/* check for fade in animation
		if (animation == animFadein) {
			Toast.makeText(getApplicationContext(), "Animation Stopped",
					Toast.LENGTH_SHORT).show();
		}*/
		if(animation == animBounce){
			  Intent intent = new Intent(this, MainActivity.class);
			  startActivity(intent);
			  finish();

		}

	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub

	}

}
