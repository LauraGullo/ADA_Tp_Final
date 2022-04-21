package com.example.concept.controllers.impl;

import com.example.concept.controllers.QuestionaryController;
import com.example.concept.service.QuestionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questionary")
public class QuestionaryControllerImpl implements QuestionaryController {
    @Autowired
    private QuestionaryService questionaryService;

    //Este endpoint devuelve todas las preguntas asociadas al id de concepto
    @GetMapping("/get_questionary/{id}")
    public ResponseEntity<?> findAllByIdConcept(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(questionaryService.findAllByIdConcept(id));
    }

    //Este endpoint valida (devuelve true) si el id respuesta corresponde al id pregunta
    @GetMapping("/validate/{idAnswers}/{idQuestion}")
    public ResponseEntity<?>validateAnswer(@PathVariable Long idAnswers, @PathVariable Long idQuestion){
        return ResponseEntity.status(HttpStatus.OK).body(questionaryService.validateAnswer(idAnswers, idQuestion));
    }

    //Este endpoint valida (devuelve true) si la respuesta es correcta
    @GetMapping("/validate/correct/{id}")
    public ResponseEntity<?>validateCorrectAnswer(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(questionaryService.validateCorrectAnswer(id));
    }
}
