package com.example.d.movieapp2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.d.movieapp2.Adapter.Movie_Adapter;
import com.example.d.movieapp2.R;
import com.example.d.movieapp2.data_models.Movie;
import com.example.d.movieapp2.data_models.Movie_Response;
import com.example.d.movieapp2.networking.MovieService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.d.movieapp2.networking.MovieService.API_KEY;
import static com.example.d.movieapp2.networking.MovieService.BASE_URL;

public class NowPlayingActivity extends AppCompatActivity {

    private MovieService nowplayingNetworking;

    private Movie_Adapter movieAdapterNowplaying;

    Retrofit nowPlayingRetrofit;

    @BindView(R.id.nowplaying_rv)
    RecyclerView nowPlaying_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        ButterKnife.bind(this);

        setNowPlayingRetrofit();
        nowPlaying_recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    public void setNowPlayingRetrofit() {
        nowPlayingRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        nowplayingNetworking = nowPlayingRetrofit.create(MovieService.class);
        Call<Movie_Response> call = nowplayingNetworking.getNowPlaying(API_KEY);

        call.enqueue(new Callback<Movie_Response>() {
            @Override
            public void onResponse(Call<Movie_Response> call, Response<Movie_Response> response) {
                Movie_Response movie_response = response.body();

                Log.e("Now Playing Retro", "I have a response");

                Log.d("NowPlaying URL", String.valueOf(call.request()));

                List<Movie> movies = movie_response.getResults();
                if (movie_response != null) {

                    for (Movie nowMovie : movies) {
                        Log.d("Movie", "onResponse " + nowMovie.getPosterPath());
                    }
                }

                movieAdapterNowplaying = new Movie_Adapter(movies, this);
                nowPlaying_recyclerView.setAdapter(movieAdapterNowplaying);
            }

            @Override
            public void onFailure(Call<Movie_Response> call, Throwable t) {

                Log.e("NO MOVIES", "Something went wrong");
                t.printStackTrace();
            }
        });


    }
}
