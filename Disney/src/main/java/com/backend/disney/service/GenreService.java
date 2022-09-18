package com.backend.disney.service;

import com.backend.disney.interfaces.IGenre;
import com.backend.disney.entity.Genre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.disney.repository.GenreRepository;

@Service
public class GenreService implements IGenre {
    
    @Autowired
    public GenreRepository genreRepo;

   @Override
    public List<Genre> getGenre() {
    return genreRepo.findAll();
    }

    @Override
    public void createGenre(Genre genre) {
       genreRepo.save(genre);
    }

    @Override
    public void deleteGenre(int id) {
        genreRepo.deleteById(id);
    }

    @Override
    public Genre searchGenre(int id) {
        return genreRepo.findById(id).orElse(null);
    }

    @Override
    public Genre editGenre(Genre genre) {
        return genreRepo.save(genre);
    }
    
    
}
