package com.example.concept.controllers;

import com.example.concept.model.dto.ChapterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ChapterController {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?>save(@RequestBody ChapterDto chapterDto);
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody ChapterDto chapterDto);
    public ResponseEntity<?>delete(@PathVariable Long id);
}
