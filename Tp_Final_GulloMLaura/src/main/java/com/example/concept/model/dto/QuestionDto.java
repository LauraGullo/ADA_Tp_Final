package com.example.concept.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QuestionDto {
    private Long idQuestion;
    private String content;
    private String idConcept;
}