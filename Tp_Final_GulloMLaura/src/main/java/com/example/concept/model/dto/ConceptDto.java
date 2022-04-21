package com.example.concept.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ConceptDto {
    private Long idConcept;
    private String name;
    private String content;
    private int number;
    private Long idChapter;

}

