package com.example.concept.controllers.impl;

import com.example.concept.controllers.ChapterController;
import com.example.concept.model.dto.ChapterDto;
import com.example.concept.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/chapter")
public class ChapterControllerImpl implements ChapterController {
    @Autowired
    private ChapterService chapterService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(chapterService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?>save(@RequestBody ChapterDto chapterDto){
        return ResponseEntity.status(HttpStatus.OK).body(chapterService.save(chapterDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody ChapterDto chapterDto){
        return ResponseEntity.status(HttpStatus.OK).body(chapterService.update(id, chapterDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(chapterService.delete(id));
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity indexOutOfBoundsException(IndexOutOfBoundsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.IM_USED);
    }


}
