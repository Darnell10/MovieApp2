package com.example.d.movieapp2.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.d.movieapp2.R;

public class SplashScreenActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(splashIntent);

                finish();

            }
        },3000);
    }
}
