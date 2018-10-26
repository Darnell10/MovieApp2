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

public class UpcomingActivity extends AppCompatActivity {

    private NetworkingInterface upcomingNetworking;

    private Movie_Adapter upcomingAdapter;

    Retrofit upcomingRetrofit;

    @BindView(R.id.upcoming_rv)
    RecyclerView upcomingRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        ButterKnife.bind(this);


        setUpcomingRetro();
        upcomingRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

    }

    public void setUpcomingRetro() {

        upcomingRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        upcomingNetworking = upcomingRetrofit.create(NetworkingInterface.class);
        Call<Movie_Response> call = upcomingNetworking.getUpcomingMovies(API_KEY);

        call.enqueue(new Callback<Movie_Response>() {
            @Override
            public void onResponse(Call<Movie_Response> call, Response<Movie_Response> response) {
                Movie_Response movie_response = response.body();

                Log.e("Upcoming Retro", "I have a Response");

                Log.d("Upcoming URL ", String.valueOf(call.request()));

                List<Movie> movies = movie_response.getResults();
                if (movie_response != null) {
                    for (Movie upcomingMovies : movies) {
                        Log.d("UPCOMING MOVIE", "OnResponse " + upcomingMovies.getPosterPath());

                    }
                }

                upcomingAdapter = new Movie_Adapter(movies, this);
                upcomingRecyclerView.setAdapter(upcomingAdapter);
            }


            @Override
            public void onFailure(Call<Movie_Response> call, Throwable t) {
                Log.e("NO MOVIES", "Something went wrong");
                t.printStackTrace();

            }
        });
    }
}
