package com.dwhyt.platzi.test.movies.data;

import com.dwhyt.platzi.test.movies.model.Genre;
import com.dwhyt.platzi.test.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static RowMapper<Movie> movieMapper = (resultSet, i) ->
            new Movie(
                resultSet.getInt("ID"),
                resultSet.getString("name"),
                resultSet.getInt("minutes"),
                Genre.valueOf(resultSet.getString("genre")),
                resultSet.getString("director"));


    @Override
    public Movie findById(long id) {
        Object[] arg = { id };
        return jdbcTemplate.queryForObject("select * from movies where id = ?", arg, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies(name, minutes, genre, director) values(?, ?, ?,?)",
                movie.getName(),
                movie.getMinutes(),
                movie.getGenre().toString(),
                movie.getDirector()
        );
    }

    @Override
    public Collection<Movie> findByName(String movieName) {

        Object[] arg = { "%"+movieName+"%" };
        return jdbcTemplate.query("Select * from movies where name like ?",
                 arg, movieMapper);
    }

    @Override
    public Collection<Movie> findByDirector(String nameDirector) {
        Object[] args = { "%"+nameDirector+"%"};
        return jdbcTemplate.query("select * from movies where director like ?", args, movieMapper);
    }

    public double calcMediaDistance(double[] positionX, double[] positionY) {
        if(positionX == null){
            return 0;
        }
        int cont =0;
        int distance =0;
        for (int i = 0; i < positionX.length; i++) {
            distance += Math.abs(positionY[i]- positionX[i]);
            cont++;
         }

        return distance/cont;
    }



    public String isCasePalindromo(String palabra){
        String charError="";
        int contErrores =0;

        for (int i=0;i<palabra.length();i++){

            if(palabra.charAt(i)!=palabra.charAt(palabra.length()-i-1)){
                contErrores++;
                charError+= palabra.charAt(i);
            }
        }

        System.out.println(contErrores);
        if( contErrores >= 4)
        {
            return "false";
        }else if(contErrores == 2 ){
            return "true- modif: " + charError.charAt(1) + "->"+charError.charAt(0);
        }
        else{
            return "true";
        }
    }

    public int numMasPopular(int[] arrayNumbers, int arrayLength){

        int numAparition=0;
        int valueReturn  =0;
        int value=0;
        int contIguales;
        int[] valueTime={0,0};

        for (int i = 0; i < arrayLength; i++) {
            valueReturn=arrayNumbers[i];
            contIguales =0;
            for (int j = 0; j < (arrayLength-i); j++) {
                if(arrayNumbers[i]== arrayNumbers[j]){
                    valueTime[0] = arrayNumbers[i];
                    valueTime[1]++;
                }
            }
        }

        int menorvalue = 0;
        for (int i = 0; i <valueTime.length ; i++) {
            if (i==0){
                menorvalue = valueTime[1];
                value = valueTime[1];
            }
            if(menorvalue<valueTime[1]){
                value = valueTime[1];
            }
        }
        return value;
    }
}
