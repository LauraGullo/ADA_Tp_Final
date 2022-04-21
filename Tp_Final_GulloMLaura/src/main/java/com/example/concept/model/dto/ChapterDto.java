package com.example.concept.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ChapterDto {
    private Long idChapter;
    private String name;
    private int number;
    private Long idLevel;
}
