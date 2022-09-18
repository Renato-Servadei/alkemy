package com.backend.disney.entity;

import com.sun.istack.NotNull;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="genres")
public class Genre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(unique=true)
    private String name;
    @NotNull
    @Column
    private String img;
    
//    @OneToMany(mappedBy="genre")
//    private List<Movie> movies = new ArrayList<Movie>();
    
    public Genre() {
    }

    public Genre (String name, String img) {
        
        this.name = name;
        this.img = img;
    }
    
    
}

