package com.example.concept.model.dto;

import com.example.concept.model.entities.Answers;
import com.example.concept.model.entities.Question;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class QuestionaryDto {

    private List<Question> questions;
    private List<Answers> answers;
}
