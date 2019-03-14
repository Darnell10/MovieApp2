package com.example.d.movieapp2.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.d.movieapp2.R;
import com.example.d.movieapp2.data_models.Movie;
import com.example.d.movieapp2.data_models.Movie_Response;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class Movie_Adapter extends RecyclerView.Adapter<Movie_Holder> {

    List<Movie> movieList;

    public Movie_Adapter(List<Movie> movies, Callback<Movie_Response> callback) {
        movieList = movies;
    }


    @NonNull
    @Override
    public Movie_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout, parent, false);
        return new Movie_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Movie_Holder holder, int position) {

//        holder.movieTitle.setText(movieList.get(position).getTitle());
//        holder.overView.setText(movieList.get(position).getOverview());
//        holder.releaseDate.setText(movieList.get(position).getReleaseDate());
        Movie movieResult = movieList.get(position);
        holder.onBind(movieResult);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }



}