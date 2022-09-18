package com.backend.disney.interfaces;

import com.backend.disney.entity.Genre;
import java.util.List;

public interface IGenre {


    public List<Genre> getGenre();
    public void createGenre(Genre genre);
    public void deleteGenre(int id);
    public Genre searchGenre(int id); 
    public Genre editGenre(Genre genre);
}
