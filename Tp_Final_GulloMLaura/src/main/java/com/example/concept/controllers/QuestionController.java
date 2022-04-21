package com.example.concept.controllers;

import com.example.concept.model.dto.QuestionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface QuestionController {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?>save(@RequestBody QuestionDto questionDto);
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody QuestionDto questionDto);
    public ResponseEntity<?>delete(@PathVariable Long id);

}
