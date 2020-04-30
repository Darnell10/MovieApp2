package com.example.d.movieapp2.dependency_injection

import com.example.d.movieapp2.models.MovieApiService
import com.example.d.movieapp2.models.MoviesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
open class ApiModule {

    private val Base_Url = "https://api.themoviedb.org/3/"

    @Provides
    fun provideMovieApi(): MoviesApi? {
        return Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MoviesApi::class.java)
    }

    @Provides
    open fun providesMovieService(): MovieApiService {
        return MovieApiService()
    }

}