package com.example.concept.controllers.impl;

import com.example.concept.controllers.ConceptController;
import com.example.concept.model.dto.ConceptDto;
import com.example.concept.service.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/concept")
public class ConceptControllerImpl implements ConceptController {

    @Autowired
    private ConceptService conceptService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
            return ResponseEntity.status(HttpStatus.OK).body(conceptService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?>save(@RequestBody ConceptDto conceptDto){
            return ResponseEntity.status(HttpStatus.OK).body(conceptService.save(conceptDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody ConceptDto conceptDto){
            return ResponseEntity.status(HttpStatus.OK).body(conceptService.update(id, conceptDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(conceptService.delete(id));
    }

    //Este endpoint devuelve un concepto aleatorio
    @GetMapping("/get_advice")
    public ResponseEntity<?>getAdvice(){
        return ResponseEntity.status(HttpStatus.OK).body(conceptService.getAdvice());
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity indexOutOfBoundsException(IndexOutOfBoundsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);
    }
}
