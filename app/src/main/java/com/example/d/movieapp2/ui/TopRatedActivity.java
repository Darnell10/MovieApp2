package com.example.d.movieapp2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.d.movieapp2.R;

import butterknife.BindView;

public class TopRatedActivity extends AppCompatActivity {

    @BindView(R.id.topRated_rv)
    RecyclerView topRated_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rated);


    }
}
