package com.example.concept.controllers;

import com.example.concept.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?>save(@RequestBody UserDto userDto);
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody UserDto userDto);
    public ResponseEntity<?>delete(@PathVariable Long id);
}
