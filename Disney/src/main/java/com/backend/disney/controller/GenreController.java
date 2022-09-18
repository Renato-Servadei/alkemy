package com.backend.disney.controller;


import com.backend.disney.interfaces.IGenre;
import com.backend.disney.entity.Genre;
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
@RequestMapping("/genre")

public class GenreController {
    
    List<Genre> listGenre = new ArrayList();
    
    @Autowired
    private IGenre genreServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void createGenre(@RequestBody Genre genre) {
        genreServ.createGenre(genre);
    }
    
    @GetMapping
    @ResponseBody
    public List<Genre> getGenre() {
        return genreServ.getGenre();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Genre searchGenre(@PathVariable("id") int id) {
        return genreServ.searchGenre(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteGenre(@PathVariable int id) {
        genreServ.deleteGenre(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<Genre> editGenre(@RequestBody Genre genre) {
        Genre editGenre = genreServ.editGenre(genre);
        return new ResponseEntity<>(editGenre, HttpStatus.OK);
}
    
}
