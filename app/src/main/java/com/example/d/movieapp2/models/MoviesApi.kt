package com.example.d.movieapp2.models

import com.example.d.movieapp2.data_models.Movie_Response
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String?): Single<List<Movie_Response>>

    @GET("movie/top_rated")
    fun getTopratedMovies(@Query("api_key") apiKey: String?): Single<List<Movie_Response>>

    @GET("movie/now_playing")
    fun getNowPlaying(@Query("api_key") apiKey: String?): Single<List<Movie_Response>>

    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String?): Single<List<Movie_Response>>

}