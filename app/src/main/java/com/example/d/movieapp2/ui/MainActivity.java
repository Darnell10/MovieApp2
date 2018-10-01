package com.example.d.movieapp2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.example.d.movieapp2.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    private Button popularButton;
    private Button topRated;
    private Button upComing;
    private Button nowPlaying;


//    @BindView(R.id.popular_button)
//    Button popularButton;
//
//    @BindView(R.id.top_rated)
//    Button topRated;
//
//    @BindView(R.id.upcoming_movies)
//    Button upComing;
//
//    @BindView(R.id.now_playing_button)
//    Button nowPlaying;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.bind(this);

        popularButton = findViewById(R.id.popular_button);

        topRated = findViewById(R.id.top_rated);

        upComing = findViewById(R.id.upcoming_movies);

        nowPlaying = findViewById(R.id.now_playing_button);
        popButton();

        topButton();

        upComingButton();

        nowPlayingButton();


    }

    public void popButton(){

        popularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void topButton(){

        topRated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void upComingButton(){
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    public void nowPlayingButton(){
        upComing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
