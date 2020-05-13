package com.dwhyt.platzi.test.movies.data;

import com.dwhyt.platzi.test.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
