package com.example.concept.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Example")
@NoArgsConstructor
@Data
public class Example implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long IdExample;
    private Long idConcept;
    private String description;
    private String content;

    @ManyToOne
    private Concept concept;
}
