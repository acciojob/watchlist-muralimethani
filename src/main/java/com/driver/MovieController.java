package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
public class MovieController {


    @Autowired
    MovieService movieService;

    /*
    1.Add a movie: POST /movies/add-movie
    Pass the Movie object as request body
    Return success message wrapped in a ResponseEntity object
    Controller Name - addMovie
     */

    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String ans = movieService.addMovie(movie);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }
}
