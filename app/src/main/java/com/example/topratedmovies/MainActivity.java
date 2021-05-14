package com.example.topratedmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MyAdapter myAdapter;
    TopRated topRated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        myAdapter = new MyAdapter(getApplicationContext(), topRated);
        recyclerView.setAdapter(myAdapter);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TopRated> call = apiService.getMovies();
        call.enqueue(new Callback<TopRated>() {

            @Override
            public void onResponse(Call<TopRated> call, Response<TopRated> response) {
                topRated = response.body();
                Log.d("TAG","Response = " + topRated);
                myAdapter.setMovieList(topRated);
            }

            @Override
            public void onFailure(Call<TopRated> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });
    }
}