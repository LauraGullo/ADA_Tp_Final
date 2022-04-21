package com.example.concept.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "concept")
@NoArgsConstructor
@Data
public class Concept implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idConcept;
    private String name;
    private Long idChapter;
    private int number;
    private String content;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Question> questions=new ArrayList<Question>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Example> examples=new ArrayList<Example>();

    @ManyToOne
    private Chapter chapter;
}
