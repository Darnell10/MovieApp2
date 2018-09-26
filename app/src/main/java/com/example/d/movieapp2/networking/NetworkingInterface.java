package com.example.d.movieapp2.networking;

import com.example.d.movieapp2.data_models.Movie;
import com.example.d.movieapp2.data_models.Movie_Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkingInterface {

    String API_KEY = "05064d0ea0a59b3c717097a5d3851776";

    String BASE_URL = "https://api.themoviedb.org/3/";


    @GET("movie/popular")
    Call<Movie_Response> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<Movie_Response> getTopratedMovies(@Query("api_key") String apiKey);



}
