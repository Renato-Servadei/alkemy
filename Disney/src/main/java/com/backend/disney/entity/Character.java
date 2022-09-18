package com.backend.disney.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Column    
    private String name;
    @NotNull
    @Column
    private int age;
    @NotNull
    @Column
    private int weight;
    @NotNull
    @Column
    private String img;
    @NotNull
    @Column
    private String history;
//    
//    @ManyToMany
//    @JoinTable(name="movie_characters",
//    joinColumns = @JoinColumn (name="character_id", referencedColumnName="id"), 
//    inverseJoinColumns = @JoinColumn (name="movie_id", referencedColumnName="id"))
//    private Set<Movie> peliculas = new HashSet<>();

    public Character() {
    }

    public Character( String name, Integer age, Integer weight, String img, String history) {
        
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.img = img;
        this.history = history;
    }
    
    
}
