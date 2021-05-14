package com.example.topratedmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MovieDetail extends AppCompatActivity {
    ImageView ivImage;
    TextView originalTitle;
    TextView rateDetail;
    TextView titleDetail;
    TextView detail;
    Movie movie;
    String imageSize = "https://www.themoviedb.org/t/p/w220_and_h330_face";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        detail();
    }

    private void detail () {
        ivImage = findViewById(R.id.ivImageDetail);
        originalTitle = findViewById(R.id.tvOriginalTitleDetail);
        rateDetail = findViewById(R.id.tvRateDetail);
        titleDetail = findViewById(R.id.tvTitleDetail);
        detail = findViewById(R.id.tvDetail);

        movie = (Movie)getIntent().getSerializableExtra("pelicula_seleccionada");

        Glide.with(this).load(imageSize + movie.getImageUrl()).apply(RequestOptions.centerCropTransform()).into(ivImage);
        originalTitle.setText(movie.getOriginalTitle());
        rateDetail.setText(movie.getRate());
        titleDetail.setText(movie.getTitle());
        detail.setText(movie.getDetail());
    }
}