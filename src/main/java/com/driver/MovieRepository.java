package com.driver;

import org.springframework.stereotype.Repository;

import  java.util.*;
import java.util.HashMap;
@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieDb = new HashMap<>();

    private HashMap<String, Director> directorDb = new HashMap<>();

    private HashMap<String, List<String>> directorAndMovie = new HashMap<>();


    public MovieRepository(HashMap<String, Movie> movieDb, HashMap<String, Director> directorDb, HashMap<String, List<String>> directorAndMovie) {
        this.movieDb = movieDb;
        this.directorDb = directorDb;
        this.directorAndMovie = directorAndMovie;
    }

    //addMovie

    public void addMovie(Movie movie){
        String movieName = movie.getName();
         movieDb.put(movie.getName(), movie);

    }

    //addDirector
    public void addDirector(Director director){
//        String directorName = director.getName();
        directorDb.put(director.getName(), director);
    }


    //3.addMovieDirectorPair
    public void addMovieDirectorPair(String movie, String director){
        if (movieDb.containsKey(movie) && directorDb.containsKey(director)){
            List<String> currentMovies = new ArrayList<>();

            if (directorAndMovie.containsKey(director)){
                currentMovies = directorAndMovie.get(director);
                currentMovies.add(movie);
                directorAndMovie.put(director, currentMovies);
            }

        }
    }
    //4.getMovieByName
    public Movie getMovieByName(String movie){
        Movie relMovie = movieDb.get(movie);
        return relMovie;
    }

    //5.getDirectorByName
    public Director getDirectorByName(String directorName){
        return directorDb.get(directorName);
    }

    //6.getMoviesByDirectorName
    public List<String> getMoviesByDirectorName (String directorName){
        List<String> moviesList = new ArrayList<>();
        if (directorAndMovie.containsKey(directorName)){
            moviesList=directorAndMovie.get(directorName);
        }

        return moviesList;
    }

    //7.findAllMovies
    public List<String> findAllMovies (){
        return new ArrayList<>(movieDb.keySet());
    }

    public void deleteDirectorByName(String name){
        List<String > movies = new ArrayList<>();
        if (directorAndMovie.containsKey(name)){
            movies = directorAndMovie.get(movies);

            for (String movie : movies){
                if (movieDb.containsKey(movie)){
                    movies.remove(movie);
                }
            }
        }

        directorAndMovie.remove(name);

        if (directorDb.containsKey(name)){
            directorDb.remove(name);
        }
    }

    public void deleteAllDirectors(){
        directorDb = new HashMap<>();
        Set<String > movieSet = new HashSet<>();
        for(String director : directorAndMovie.keySet()){
            for (String movie : directorAndMovie.get(director)){
                movieSet.add(movie);
            }
        }

        for (String movie : movieSet){
            if (movieDb.containsKey(movie)){
                movieDb.remove(movie);
            }
        }
        directorAndMovie = new HashMap<>();
    }

}
