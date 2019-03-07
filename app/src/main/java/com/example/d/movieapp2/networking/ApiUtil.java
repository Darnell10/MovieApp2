package com.example.d.movieapp2.networking;

public class ApiUtil {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    public static MovieService getApiService(){

        return RetrofitClient.getRetrofit(BASE_URL).create(MovieService.class);
    }
}
