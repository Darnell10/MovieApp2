package com.example.d.movieapp2.controller;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.d.movieapp2.R;
import com.example.d.movieapp2.data_models.Movie;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Movie_Holder extends RecyclerView.ViewHolder {

    //private ImageView movieImage;
   // private TextView movieTitle;
   // private TextView releaseDate;
    //private TextView overView;

    @BindView(R.id.movie_imageview)
    ImageView movieImage;

    @BindView(R.id.movie_title)
    TextView movieTitle;

    @BindView(R.id.release_date)
    TextView releaseDate;

    @BindView(R.id.overview)
    TextView overView;

    public Movie_Holder(View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);

//        movieImage = itemView.findViewById(R.id.movie_imageview);
//        movieTitle = itemView.findViewById(R.id.movie_title);
//        releaseDate = itemView.findViewById(R.id.release_date);
//        overView = itemView.findViewById(R.id.overview);
//        movieImage = itemView.findViewById(R.id.movie_imageview);
    }

    public void onBind(Movie movieResult) {
        String urlPath = "https://image.tmdb.org/t/p/w500" + movieResult.getPosterPath();
        Picasso.with(itemView.getContext())
                .load(urlPath)
                .placeholder(R.drawable.movie_informant)
                .error(R.drawable.movie_informant)
                .into(movieImage);
    }
}

