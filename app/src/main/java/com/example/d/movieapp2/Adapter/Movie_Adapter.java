package com.example.d.movieapp2.Adapter;

import android.content.Context;
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
import com.example.d.movieapp2.ui.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class Movie_Adapter extends RecyclerView.Adapter<Movie_Adapter.Movie_Holder> {

    List<Movie> movieList;

    public Movie_Adapter(List<Movie> movies, Callback<Movie_Response> callback) {
        movieList =movies;
    }


    @NonNull
    @Override
    public Movie_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout,parent,false);
        return new Movie_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Movie_Holder holder, int position) {

        holder.movieTitle.setText(movieList.get(position).getTitle());
        holder.overView.setText(movieList.get(position).getOverview());
        holder.releaseDate.setText(movieList.get(position).getReleaseDate());
        Movie movieResult = movieList.get(position);
        holder.onBind(movieResult);

//                .load("https://image.themoviedb.org/3/movie/550"+movieList
//                        .get(position).getPosterPath()).into(holder.movieImage);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class Movie_Holder extends RecyclerView.ViewHolder {

        private ImageView movieImage;
        private TextView movieTitle;
        private TextView releaseDate;
        private TextView overView;


        public Movie_Holder(View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.movie_imageview);
            movieTitle = itemView.findViewById(R.id.movie_title);
            releaseDate = itemView.findViewById(R.id.release_date);
            overView = itemView.findViewById(R.id.overview);
            movieImage = itemView.findViewById(R.id.movie_imageview);
        }

        public void onBind(Movie movieResult) {
            Picasso.with(itemView.getContext())
                    .load(movieResult.getPosterPath())
                    .into(movieImage);
        }
    }

}