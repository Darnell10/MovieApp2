package com.example.d.movieapp2.networking;

import com.example.d.movieapp2.data_models.Movie_Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkingInterface {

    String API_KEY = "05064d0ea0a59b3c717097a5d3851776";

    //String BASEURL = "";



    //@GET("/discover/movie?sort_by=popularity.desc")

    @GET("discover/movie")
    Observable<Movie_Response> getMovies(@Query(API_KEY) String apiKey, @Query("sort_by") String query);


    @GET("search/movie")
    Observable<Movie_Response> getMoviesBasedOnQuery(@Query(API_KEY) String api_key, @Query("query") String query);

}
