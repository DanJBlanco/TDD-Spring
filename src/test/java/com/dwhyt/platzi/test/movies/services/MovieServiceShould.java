package com.dwhyt.platzi.test.movies.services;

import com.dwhyt.platzi.test.movies.data.MovieRepository;
import com.dwhyt.platzi.test.movies.model.Genre;
import com.dwhyt.platzi.test.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = new Mockito().mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Movie1", 120, Genre.ACTION, "director1"),
                        new Movie(2, "Movie2", 112, Genre.THRILLER, "director2"),
                        new Movie(3, "Movie3", 113, Genre.COMEDY, "director3"),
                        new Movie(4, "Movie4", 114, Genre.THRILLER, "director4"),
                        new Movie(5, "Movie5", 115, Genre.HORROR, "director5"),
                        new Movie(6, "Movie6", 119, Genre.COMEDY, "director6"),
                        new Movie(7, "Movie7", 130, Genre.ACTION, "director7")
                )
        );

        movieService = new MovieService(movieRepository);

    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMovieByGenre(Genre.COMEDY);
        assertThat(getMovieIds(movies), is(Arrays.asList(3,6)));
    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> movies = movieService.findMovieByLength(119);
        assertThat(getMovieIds(movies), is(Arrays.asList(2,3,4,5,6)));
    }

    @Test
    public void return_movie_by_id() {

    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }



}