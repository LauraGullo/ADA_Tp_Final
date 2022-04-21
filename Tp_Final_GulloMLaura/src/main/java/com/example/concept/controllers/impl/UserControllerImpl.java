package com.example.concept.controllers.impl;

import com.example.concept.controllers.UserController;
import com.example.concept.model.dto.UserDto;
import com.example.concept.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?>save(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(userDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(id, userDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userService.delete(id));
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity indexOutOfBoundsException(IndexOutOfBoundsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);
    }
}
