package com.example.concept.controllers.impl;

import com.example.concept.controllers.AnswersController;
import com.example.concept.model.dto.AnswersDto;
import com.example.concept.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswersControllerImpl implements AnswersController {
    @Autowired
    private AnswersService answersService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
            return ResponseEntity.status(HttpStatus.OK).body(answersService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?>save(@RequestBody AnswersDto answersDto){
            return ResponseEntity.status(HttpStatus.OK).body(answersService.save(answersDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody AnswersDto answersDto){
            return ResponseEntity.status(HttpStatus.OK).body(answersService.update(id, answersDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(answersService.delete(id));
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity indexOutOfBoundsException(IndexOutOfBoundsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);
    }
}
