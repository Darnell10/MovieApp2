package com.example.d.movieapp2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.d.movieapp2.Adapter.Movie_Adapter;
import com.example.d.movieapp2.R;
import com.example.d.movieapp2.networking.NetworkingInterface;

import butterknife.BindView;

public class NowPlayingActivity extends AppCompatActivity {

    private NetworkingInterface nowplayingNetworking;

    private Movie_Adapter movieAdapterNowplaying;

    @BindView(R.id.nowplaying_rv)
    RecyclerView nowPlaying_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        nowPlaying_recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }
}
