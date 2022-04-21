package com.example.concept.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chapter")
@NoArgsConstructor
@Data
public class Chapter implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idChapter;
    private String name;
    private int number;
    private Long idLevel;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Concept> concepts=new ArrayList<Concept>();

    @ManyToOne
    private Level level;



}
