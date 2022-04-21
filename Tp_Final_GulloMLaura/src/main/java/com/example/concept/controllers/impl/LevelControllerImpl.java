package com.example.concept.controllers.impl;

import com.example.concept.controllers.LevelController;
import com.example.concept.model.dto.LevelDto;
import com.example.concept.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Level")
public class LevelControllerImpl implements LevelController {
    @Autowired
    private LevelService levelService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(levelService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?>save(@RequestBody LevelDto levelDto){
        return ResponseEntity.status(HttpStatus.OK).body(levelService.save(levelDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody LevelDto levelDto){
        return ResponseEntity.status(HttpStatus.OK).body(levelService.update(id, levelDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(levelService.delete(id));
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity indexOutOfBoundsException(IndexOutOfBoundsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);
    }
}
