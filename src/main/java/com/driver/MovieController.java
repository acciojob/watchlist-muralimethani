package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;


@RestController
//@RequestMapping("movies")
public class MovieController {


    @Autowired
    MovieService movieService;

    /*
    1.Add a movie: POST /movies/add-movie
    Pass the Movie object as request body
    Return success message wrapped in a ResponseEntity object
    Controller Name - addMovie
     */


    //1.addMovie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
         movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }

    //2.addDirector
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);
    }

    //4.getMovieByName
    @GetMapping("/get-movie-by-name/{name}")
    public  ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        //public  ResponseEntity<Student> getByPath(@PathVariable("admNo") Integer admNo){
        Movie movie =movieService.getMovieByName(name);
        return  new ResponseEntity<>(movie, HttpStatus.CREATED);
    }


    //5.getDirectorByName
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }


    //3.addMovieDirectorPair
    @PostMapping("/add-movie-director-pair")
    public  ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New movie-director pair added successfully", HttpStatus.CREATED);
    }


    //6. getMoviesByDirectorName
    @GetMapping ("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name") String  name){
        List<String> moviesList =new ArrayList<>();
               moviesList= movieService.getMoviesByDirectorName(name);
        return  new ResponseEntity<>(moviesList,HttpStatus.CREATED);
    }

    @GetMapping ("/get-all-movies")
    public ResponseEntity<List<String >> findAllMovies (){
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public  ResponseEntity<String > deleteDirectorByName(@RequestParam String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("Successfully removed", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);
    }

}
