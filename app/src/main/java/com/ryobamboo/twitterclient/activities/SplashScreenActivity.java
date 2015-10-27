package com.ryobamboo.twitterclient.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ryobamboo.twitterclient.MainActivity;
import com.ryobamboo.twitterclient.R;

public class SplashScreenActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashScreenActivity.this.finish();
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                SplashScreenActivity.this.startActivity(intent);
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
