package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class MovieRepository {
    HashMap<String, Movie> movieDb = new HashMap<>();

    HashMap<String, Director> directorDb = new HashMap<>();

    public String addMovie(Movie movie){
        String movieName = movie.getName();
        Movie resultMovie = movieDb.put(movieName, movie);
        return "Movie added successfully";
    }

}
