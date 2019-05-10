package com.example.d.movieapp2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.d.movieapp2.R;
import com.example.d.movieapp2.data_models.Movie_Response;
import com.example.d.movieapp2.networking.ApiUtil;
import com.example.d.movieapp2.networking.MovieService;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewNowPlayingActivity extends AppCompatActivity {

    private static final String TAG = "Retrofit Call";

    private MovieService movieService;

    @BindView(R.id.new_now_playing)
    RecyclerView nowPlayingRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_now_playing);

        movieService = ApiUtil.getApiService();

    }

    public void retrofitCall(){
        movieService.getNowPlaying(MovieService.API_KEY).enqueue(new Callback<Movie_Response>() {
            @Override
            public void onResponse(Call<Movie_Response> call, Response<Movie_Response> response) {

                Movie_Response movie_response = response.body();

                Log.e(TAG,String.valueOf(call.request()));


            }

            @Override
            public void onFailure(Call<Movie_Response> call, Throwable t) {

                t.printStackTrace();
            }
        });
    }
}
