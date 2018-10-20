package com.example.d.movieapp2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.d.movieapp2.R;

import butterknife.BindView;

public class UpcomingActivity extends AppCompatActivity {

    @BindView(R.id.upcoming_rv)
    RecyclerView upcomingRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);

        upcomingRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }
}
