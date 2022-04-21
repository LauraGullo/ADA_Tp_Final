package com.example.concept.service;

import com.example.concept.model.dto.QuestionDto;

import java.util.List;

public interface QuestionaryService {
    public Boolean validateAnswer(Long idAnswers, Long idQuestion);
    public boolean validateCorrectAnswer(Long id);
    public List<QuestionDto> findAllByIdConcept(Long id);

}
