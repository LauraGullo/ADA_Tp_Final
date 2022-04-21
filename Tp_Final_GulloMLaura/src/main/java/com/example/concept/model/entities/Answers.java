package com.example.concept.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answers")
@NoArgsConstructor
@Data
public class Answers implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idAnswers;
    private String content;
    private Long idQuestion;
    private boolean itsCorrect;

    @ManyToOne
    private Question question;
}
