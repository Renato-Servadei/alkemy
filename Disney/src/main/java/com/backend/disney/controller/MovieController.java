package com.backend.disney.controller;


import com.backend.disney.interfaces.IMovie;
import com.backend.disney.entity.Movie;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")

public class MovieController {
    
    List<Movie> listMovie = new ArrayList();
    
    @Autowired
    private IMovie movieServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void createMovie(@RequestBody Movie movie) {
        movieServ.createMovie(movie);
    }
    
    @GetMapping
    @ResponseBody
    public List<Movie> getMovie() {
        return movieServ.getMovie();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Movie searchMovie(@PathVariable("id") int id) {
        return movieServ.searchMovie(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable int id) {
        movieServ.deleteMovie(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<Movie> editMovie(@RequestBody Movie movie) {
        Movie editMovie = movieServ.editMovie(movie);
        return new ResponseEntity<>(editMovie, HttpStatus.OK);
}
    
}
