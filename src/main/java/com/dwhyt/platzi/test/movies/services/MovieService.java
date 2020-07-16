package com.dwhyt.platzi.test.movies.services;

import com.dwhyt.platzi.test.movies.data.MovieRepository;
import com.dwhyt.platzi.test.movies.model.Genre;
import com.dwhyt.platzi.test.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMovieByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(x -> x.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByLength(int minutes) {
        return movieRepository.findAll().stream()
                .filter(x -> x.getMinutes() <= minutes).collect(Collectors.toList());
    }
}
