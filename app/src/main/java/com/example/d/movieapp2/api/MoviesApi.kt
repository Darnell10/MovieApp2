package com.example.d.movieapp2.api

import com.example.d.movieapp2.models.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String?): Single<List<MovieResponse>>

    @GET("movie/top_rated")
    fun getTopratedMovies(@Query("api_key") apiKey: String?): Single<List<MovieResponse>>

    @GET("movie/now_playing")
    fun getNowPlaying(@Query("api_key") apiKey: String?): Single<List<MovieResponse>>

    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String?): Single<List<MovieResponse>>

}