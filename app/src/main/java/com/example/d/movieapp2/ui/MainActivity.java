package com.example.d.movieapp2.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.d.movieapp2.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.popular_button)
    Button popularButton;

    @BindView(R.id.top_rated)
    Button topRated;

    @BindView(R.id.upcoming_movies)
    Button upComing;

    @BindView(R.id.now_playing_button)
    Button nowPlaying;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        popButton();

        topButton();

        upComingButton();

        nowPlayingButton();


    }

    public void popButton() {

        popularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("PRESSED", "POPULAR");

                Intent popularIntent = new Intent(v.getContext(), Popular_Activity.class);
                v.getContext().startActivity(popularIntent);

            }
        });

    }

    public void topButton() {

        topRated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("PRESSED", "TOP");

                Intent topIntent = new Intent(v.getContext(), TopRatedActivity.class);
                v.getContext().startActivity(topIntent);

            }
        });
    }

    public void upComingButton() {
        upComing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("PRESSED", "Upcoming");

                Intent upComingIntent = new Intent(v.getContext(), UpcomingActivity.class);
                v.getContext().startActivity(upComingIntent);
            }
        });

    }


    public void nowPlayingButton() {
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("PRESSED", "Now Playing ");

                Intent nowplayingIntent = new Intent(v.getContext(), NowPlayingActivity.class);
                v.getContext().startActivity(nowplayingIntent);
            }
        });
    }
}
