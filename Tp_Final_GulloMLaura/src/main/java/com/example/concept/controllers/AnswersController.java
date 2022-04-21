package com.example.concept.controllers;

import com.example.concept.model.dto.AnswersDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface AnswersController {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?>save(@RequestBody AnswersDto answersDto);
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody AnswersDto answersDto);
    public ResponseEntity<?>delete(@PathVariable Long id);
}
