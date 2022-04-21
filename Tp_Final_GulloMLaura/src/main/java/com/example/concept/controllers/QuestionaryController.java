package com.example.concept.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface QuestionaryController {
    public ResponseEntity<?> findAllByIdConcept(@PathVariable Long id);
    public ResponseEntity<?>validateAnswer(@PathVariable Long idAnswers, @PathVariable Long idQuestion);
    public ResponseEntity<?>validateCorrectAnswer(@PathVariable Long id);
}
