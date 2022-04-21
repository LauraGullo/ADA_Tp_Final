package com.example.concept.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
@NoArgsConstructor
@Data
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idQuestion;
    private String content;
    private Long idConcept;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Answers> answers=new ArrayList<Answers>();

    @ManyToOne
    private Concept concept;

}
