package com.example.concept.controllers;

import com.example.concept.model.dto.ExampleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ExampleController {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?>save(@RequestBody ExampleDto exampleDto);
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody ExampleDto exampleDto);
    public ResponseEntity<?>delete(@PathVariable Long id);
}
