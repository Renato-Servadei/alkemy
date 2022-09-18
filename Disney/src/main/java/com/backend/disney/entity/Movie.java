package com.backend.disney.entity;

import com.sun.istack.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="movies")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column
    private String title;
    @NotNull
    @Column
    private String img;
    @NotNull
    @Column
    private String date;
    @NotNull
    @Column
    private int cal;
//
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name="fk_genre")
//    private Genre genre;
//    
//    @ManyToMany(mappedBy= "movies")
//    private Set<Character> characters = new HashSet<>();
    
    public Movie() {
    }

    public Movie(String title, String img, String date, Integer cal) {
        
        this.title = title;
        this.img = img;
        this.date = date;
        this.cal = cal;
    }
    
    
}
    
    

    