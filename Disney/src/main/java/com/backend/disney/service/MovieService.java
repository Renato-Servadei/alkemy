package com.backend.disney.service;

import com.backend.disney.interfaces.IMovie;
import com.backend.disney.entity.Movie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.disney.repository.MovieRepository;

@Service
public class MovieService implements IMovie {
    
    @Autowired
    public MovieRepository movieRepo;

   @Override
    public List<Movie> getMovie() {
    return movieRepo.findAll();
    }

    @Override
    public void createMovie(Movie movie) {
       movieRepo.save(movie);
    }

    @Override
    public void deleteMovie(int id) {
        movieRepo.deleteById(id);
    }

    @Override
    public Movie searchMovie(int id) {
        return movieRepo.findById(id).orElse(null);
    }

    @Override
    public Movie editMovie(Movie movie) {
        return movieRepo.save(movie);
    }
    
    
}
