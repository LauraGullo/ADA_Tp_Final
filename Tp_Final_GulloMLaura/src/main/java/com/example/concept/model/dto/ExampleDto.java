package com.example.concept.model.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ExampleDto {
    private Long IdExample;
    private Long idConcept;
    private String description;
    private String content;
}
