package com.example.concept.controllers.impl;

import com.example.concept.controllers.QuestionController;
import com.example.concept.model.dto.QuestionDto;
import com.example.concept.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionControllerImpl implements QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
            return ResponseEntity.status(HttpStatus.OK).body(questionService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?>save(@RequestBody QuestionDto questionDto){
            return ResponseEntity.status(HttpStatus.OK).body(questionService.save(questionDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody QuestionDto questionDto){
            return ResponseEntity.status(HttpStatus.OK).body(questionService.update(id, questionDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(questionService.delete(id));
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity indexOutOfBoundsException(IndexOutOfBoundsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);
    }
}
