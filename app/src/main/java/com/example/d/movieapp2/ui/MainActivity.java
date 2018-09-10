package com.example.d.movieapp2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.d.movieapp2.Adapter.Movie_Adapter;
import com.example.d.movieapp2.R;
import com.example.d.movieapp2.data_models.Movie_Response;
import com.example.d.movieapp2.data_models.Movie;
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

public class MainActivity extends AppCompatActivity {



    private NetworkingInterface networkInterface;

    private Movie_Adapter movie_adapter;

    private Movie result;

    private Movie_Response movie_response;

    Retrofit retrofit;

    List<Movie> movies;

    @BindView(R.id.movie_imageview) ImageView movieImageview;

    @BindView(R.id.movie_title) TextView movieTitle;

    @BindView(R.id.release_date)TextView releaseDate;

    @BindView(R.id.overview)TextView overView;

    @BindView(R.id.recyclerview_view) RecyclerView recyclerView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setRetrofit();
        setRecyclerView(movies);


    }


    public void setRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        networkInterface = retrofit.create(NetworkingInterface.class);
        Call<Movie_Response> call = networkInterface.getPopularMovies(API_KEY);

        call.enqueue(new Callback<Movie_Response>() {
            @Override
            public void onResponse(Call<Movie_Response> call, Response<Movie_Response> response) {
                Movie_Response  movie_response = response.body();

                Log.e("I Have a response", "Response");

                List<Movie> movies = movie_response.getResults();
                if(movie_response != null){

                    for (Movie movie : movies) {
                        Log.d("MOVIE", "onResponse: " + movie.getTitle());
                    }
                }
                setRecyclerView(movies);

            }

            @Override
            public void onFailure(Call<Movie_Response> call, Throwable t) {

                Log.e("NO MOVIES", "Something went wrong");
                t.printStackTrace();

            }
        });


    }

    public void setRecyclerView(List<Movie> movies){
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        movie_adapter = new Movie_Adapter(movies,this);
        recyclerView.setAdapter(movie_adapter);
    }


}
