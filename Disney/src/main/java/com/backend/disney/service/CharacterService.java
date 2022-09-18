package com.backend.disney.service;

import com.backend.disney.interfaces.ICharacter;
import com.backend.disney.entity.Character;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.disney.repository.CharacterRepository;

@Service
public class CharacterService implements ICharacter {
    
    @Autowired
    public CharacterRepository characterRepo;

   @Override
    public List<Character> getCharacter() {
    return characterRepo.findAll();
    }

    @Override
    public void createCharacter(Character character) {
       characterRepo.save(character);
    }

    @Override
    public void deleteCharacter(int id) {
        characterRepo.deleteById(id);
    }

    @Override
    public Character searchCharacter(int id) {
        return characterRepo.findById(id).orElse(null);
    }

    @Override
    public Character editCharacter(Character character) {
        return characterRepo.save(character);
    }
    
    
}
