package com.example.concept.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AnswersDto {
    private Long idAnswers;
    private String content;
    private String idQuestion;
    private boolean itsCorrect;
}