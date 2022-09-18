package com.backend.disney.controller;


import com.backend.disney.entity.Character;
import com.backend.disney.interfaces.ICharacter;
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
@RequestMapping("/characters")

public class CharacterController {
    
    List<Character> listCharacter = new ArrayList();
    
    @Autowired
    private ICharacter characterServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void creteCharacter(@RequestBody Character character) {
        characterServ.createCharacter(character);
    }
    
    @GetMapping
    @ResponseBody
    public List<Character> getCharacter() {
        return characterServ.getCharacter();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Character searchCharacter(@PathVariable("id") int id) {
        return characterServ.searchCharacter(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{idPer}")
    public void deleteCharacter(@PathVariable int id) {
        characterServ.deleteCharacter(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<Character> editCharacter(@RequestBody Character character) {
        Character editCharacter = characterServ.editCharacter(character);
        return new ResponseEntity<>(editCharacter, HttpStatus.OK);
}
    
}
