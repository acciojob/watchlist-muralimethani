package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public  String addMovie(Movie movie){
        String ans = movieRepository.addMovie(movie);
//        return addedMovie;
        return ans;

    }
}
