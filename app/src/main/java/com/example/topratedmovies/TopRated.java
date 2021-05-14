package com.example.topratedmovies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopRated {
    @SerializedName("page")
    private String page;

    @SerializedName("results")
    private List<Movie> results;

    public TopRated(String page, List<Movie> results) {
        this.page = page;
        this.results = results;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
