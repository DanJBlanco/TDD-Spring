package com.dwhyt.platzi.test.movies.data;

import com.dwhyt.platzi.test.movies.model.Genre;
import com.dwhyt.platzi.test.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepositoryJdbc;
    private DataSource dataSource;
    @Before
    public void setUp() throws Exception {
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL","sa","sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);

    }

    @Test
    public void load_all_movies() throws SQLException {

        Collection<Movie> movies = movieRepositoryJdbc.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1,"peli1",152, Genre.ACTION, "director1"),
                new Movie(2,"peli2",113, Genre.THRILLER, "director2"),
                new Movie(3,"peli3",136, Genre.ACTION, "director3")
        )));
    }

    @Test
    public void load_movie_by_id() {
        assertThat(movieRepositoryJdbc.findById(2),is(new Movie(2,"peli2",113, Genre.THRILLER, "director2")));
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie(4,"Super 8", 112, Genre.THRILLER, "directorTest");

        movieRepositoryJdbc.saveOrUpdate(movie);

        Movie movieFromDb = movieRepositoryJdbc.findById(4);

        assertThat(movieFromDb, is(movie));

    }

    @Test
    public void find_by_name() {
        Collection<Movie> movies = movieRepositoryJdbc.findByName("peli");

        assertThat(movies, is(Arrays.asList(
                new Movie(1,"peli1",152, Genre.ACTION, "director1"),
                new Movie(2,"peli2",113, Genre.THRILLER, "director2"),
                new Movie(3,"peli3",136, Genre.ACTION, "director3")
        )));
    }

    @Test
    public void find_by_director() {
        Collection<Movie> movies = movieRepositoryJdbc.findByDirector("director");
        assertThat(movies, is(Arrays.asList(
                new Movie(1,"peli1",152, Genre.ACTION, "director1"),
                new Movie(2,"peli2",113, Genre.THRILLER, "director2"),
                new Movie(3,"peli3",136, Genre.ACTION, "director3")
        )));
    }

    @After
    public void tearDown() throws Exception {
        // Remove H2 files -- https://stackoverflow.com/a/51809831/1121497"
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
        // "shutdown" is also enough for mem db
    }

    @Test
    public void return_media_distance() {
        double[] positionX = {2,4,5};
        double[] positionY = {3,5,7};
        double media = movieRepositoryJdbc.calcMediaDistance(positionX, positionY);
        assertEquals(media,is(1.3));
    }

    @Test
    public void return_palindrome() {
        assertEquals("true", movieRepositoryJdbc.isCasePalindromo("abccba"));
        assertEquals("true- modif: x->a", movieRepositoryJdbc.isCasePalindromo("abccbx"));
        assertEquals("false", movieRepositoryJdbc.isCasePalindromo("abccfg"));
    }
}