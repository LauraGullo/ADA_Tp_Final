package com.example.concept.controllers;

import com.example.concept.model.dto.ConceptDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ConceptController {

        public ResponseEntity<?>getAll();
        public ResponseEntity<?>save(@RequestBody ConceptDto conceptDto);
        public ResponseEntity<?>update(@PathVariable Long id, @RequestBody ConceptDto conceptDto);
        public ResponseEntity<?>delete(@PathVariable Long id);
        public ResponseEntity<?>getAdvice();


}
