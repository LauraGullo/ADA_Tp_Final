package com.example.concept.controllers;

import com.example.concept.model.dto.ConceptDto;
import com.example.concept.model.dto.LevelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface LevelController {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?>save(@RequestBody LevelDto levelDto);
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody LevelDto levelDto);
    public ResponseEntity<?>delete(@PathVariable Long id);
}
