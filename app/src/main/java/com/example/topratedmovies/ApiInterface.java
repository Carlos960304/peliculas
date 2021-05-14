package com.example.topratedmovies;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("movie/top_rated?api_key=d8123829be5136b5a19be84caa8ed7ed&language=es-MX&page=1")
    Call<TopRated> getMovies();
}
