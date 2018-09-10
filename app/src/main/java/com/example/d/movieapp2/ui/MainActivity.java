package com.example.d.movieapp2.ui;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.d.movieapp2.R;
import com.example.d.movieapp2.data_models.Result;

import java.net.NetworkInterface;
import java.util.List;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    NetworkInterface networkInterface;

    List<Result> movieResults;

    RecyclerView recyclerView;

    Configuration configuration;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



}
