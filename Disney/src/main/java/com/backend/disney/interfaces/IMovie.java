package com.backend.disney.interfaces;

import com.backend.disney.entity.Movie;
import java.util.List;

public interface IMovie {


    public List<Movie> getMovie();
    public void createMovie(Movie movie);
    public void deleteMovie(int id);
    public Movie searchMovie(int id); 
    public Movie editMovie(Movie movie);
}
