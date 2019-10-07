package com.twu.biblioteca;

import java.util.List;

public class MovieShop {
    private List<Movie> movies;

    public MovieShop(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
