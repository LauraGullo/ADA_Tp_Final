package com.example.concept.service;

import com.example.concept.model.dto.QuestionDto;

import java.util.List;

public interface QuestionService <E>{
    public List<QuestionDto> findAll();
    public QuestionDto save(QuestionDto questionDto);
    public QuestionDto update(Long id, QuestionDto questionDto);
    public boolean delete(Long id);


}
