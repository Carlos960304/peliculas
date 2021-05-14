package com.example.topratedmovies;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {
    @SerializedName("poster_path")
    private String imageUrl;

    @SerializedName("original_title")
    private String original_title;

    @SerializedName("vote_average")
    private String rate;

    @SerializedName("id")
    private Integer idMovie;

    @SerializedName("overview")
    private String detail;

    @SerializedName("title")
    private String title;

    public Movie(String imageUrl, String original_title, String rate, Integer idMovie, String detail, String title) {
        this.imageUrl = imageUrl;
        this.original_title = original_title;
        this.rate = rate;
        this.idMovie = idMovie;
        this.detail = detail;
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public void setOriginalTitle(String original_title) {
        this.original_title = original_title;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
