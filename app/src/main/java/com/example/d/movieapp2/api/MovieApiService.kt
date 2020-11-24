package com.example.d.movieapp2.api

import com.example.d.movieapp2.models.MovieResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class MovieApiService {

    private val Base_Url = "https://api.themoviedb.org/3/"

    private val API_KEY = "05064d0ea0a59b3c717097a5d3851776"

    private val apiService = Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MoviesApi::class.java)


    fun getNowPlaying(): Single<List<MovieResponse>> {
        return apiService.getNowPlaying(API_KEY)
    }

    fun getTopratedMovies(): Single<List<MovieResponse>> {
        return apiService.getTopratedMovies(API_KEY)
    }

    fun getPopularMovies(): Single<List<MovieResponse>> {
        return apiService.getPopularMovies(API_KEY)
    }

    fun getUpcomingMovies(): Single<List<MovieResponse>> {
        return apiService.getUpcomingMovies(API_KEY)
    }

}