package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    //1.addMovie
    public  void  addMovie(Movie movie){
       movieRepository.addMovie(movie);
    }


    //2.addDirector
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }


    //4.getMovieByName

    public Movie getMovieByName(String name){
        Movie movie = movieRepository.getMovieByName(name);
        return movie;
    }


    //5.getDirectorByName
    public Director  getDirectorByName(String DirectorName){
         Director dir =movieRepository.getDirectorByName(DirectorName);
         return  dir;

    }

    //3.addMovieDirectorPair

    public void addMovieDirectorPair(String movie, String director){
        movieRepository.addMovieDirectorPair(movie, director);
    }


    //6.getMoviesByDirectorName
    public List<String> getMoviesByDirectorName (String directorName){
        List<String> moviesList = new ArrayList<>();
        moviesList=movieRepository.getMoviesByDirectorName(directorName);
        return moviesList;
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String name){
         movieRepository.deleteDirectorByName(name);
    }

    public void deleteAllDirectors(){
         movieRepository.deleteAllDirectors();
    }
}
