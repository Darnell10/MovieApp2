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
import com.example.d.movieapp2.networking.NetworkingInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.d.movieapp2.networking.NetworkingInterface.API_KEY;
import static com.example.d.movieapp2.networking.NetworkingInterface.BASE_URL;

public class TopRatedActivity extends AppCompatActivity {

    private NetworkingInterface topRatedNetworking;

    private Movie_Adapter topRatedMovieAdapter;

    Retrofit topRatedRetrofit;

    @BindView(R.id.topRated_rv)
    RecyclerView topRated_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rated);
        ButterKnife.bind(this);

        setTopRatedRetro();
        topRated_recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

    }

    public void setTopRatedRetro() {

        topRatedRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        topRatedNetworking = topRatedRetrofit.create(NetworkingInterface.class);
        Call<Movie_Response> call = topRatedNetworking.getTopratedMovies(API_KEY);

        call.enqueue(new Callback<Movie_Response>() {
            @Override
            public void onResponse(Call<Movie_Response> call, Response<Movie_Response> response) {
                Movie_Response movie_response = response.body();

                Log.e("Top Rated Retro", "I have a Response");

                Log.d("TopRated URL", String.valueOf(call.request()));

                List<Movie> movies = movie_response.getResults();
                if (movie_response != null) {
                    for (Movie topMovie : movies) {
                        Log.d("TOP RATED MOVIE", "OnResponse " + topMovie.getPosterPath());
                    }
                }

                topRatedMovieAdapter = new Movie_Adapter(movies, this);
                topRated_recyclerView.setAdapter(topRatedMovieAdapter);
            }

            @Override
            public void onFailure(Call<Movie_Response> call, Throwable t) {

                Log.e(" NO MOVIES", "Something went wrong");
                t.printStackTrace();
            }
        });


    }
}
