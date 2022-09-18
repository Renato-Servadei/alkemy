package com.backend.disney.interfaces;

import com.backend.disney.entity.Character;
import java.util.List;

public interface ICharacter {


    public List<Character> getCharacter();
    public void createCharacter(Character character);
    public void deleteCharacter(int id);
    public Character searchCharacter(int id); 
    public Character editCharacter(Character character);    
}
