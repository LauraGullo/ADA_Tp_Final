package com.example.concept.controllers.impl;

import com.example.concept.controllers.ExampleController;
import com.example.concept.model.dto.ExampleDto;
import com.example.concept.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
public class ExampleControllerImpl implements ExampleController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(exampleService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody ExampleDto exampleDto) {
        return ResponseEntity.status(HttpStatus.OK).body(exampleService.save(exampleDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ExampleDto exampleDto) {
        return ResponseEntity.status(HttpStatus.OK).body(exampleService.update(id, exampleDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(exampleService.delete(id));
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity indexOutOfBoundsException(IndexOutOfBoundsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);
    }
}