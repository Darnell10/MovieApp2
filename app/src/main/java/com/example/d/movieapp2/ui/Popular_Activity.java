package com.example.d.movieapp2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.d.movieapp2.Adapter.Movie_Adapter;
import com.example.d.movieapp2.R;
import com.example.d.movieapp2.data_models.Movie_Response;
import com.example.d.movieapp2.data_models.Movie;
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

public class Popular_Activity extends AppCompatActivity {


    private MovieService networkInterface;

    private Movie_Adapter movie_adapter;


    Retrofit retrofit;


    @BindView(R.id.popular_rv)
    RecyclerView popular_RecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
        ButterKnife.bind(this);

        setRetrofit();
        popular_RecyclerView.setLayoutManager(new GridLayoutManager(this, 1));


    }


    public void setRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        networkInterface = retrofit.create(MovieService.class);
        Call<Movie_Response> call = networkInterface.getPopularMovies(API_KEY);

        call.enqueue(new Callback<Movie_Response>() {
            @Override
            public void onResponse(Call<Movie_Response> call, Response<Movie_Response> response) {
                Movie_Response movie_response = response.body();

                Log.e("I Have a response", "Response");

                Log.d("URL", String.valueOf(call.request()));

                List<Movie> movies = movie_response.getResults();
                if (movie_response != null) {

                    for (Movie movie : movies) {
                        Log.d("MOVIE", "onResponse: " + movie.getPosterPath());
                    }
                }
                movie_adapter = new Movie_Adapter(movies, this);
                popular_RecyclerView.setAdapter(movie_adapter);
                //setRecyclerView(movies);

            }

            @Override
            public void onFailure(Call<Movie_Response> call, Throwable t) {

                Log.e("NO MOVIES", "Something went wrong");
                t.printStackTrace();

            }
        });


    }


}
