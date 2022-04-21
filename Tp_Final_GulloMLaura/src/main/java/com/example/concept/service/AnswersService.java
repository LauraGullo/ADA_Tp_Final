package com.example.concept.service;

import com.example.concept.model.dto.AnswersDto;

import java.util.List;

public interface AnswersService<E> {
    public List<AnswersDto> findAll() ;
    public AnswersDto save(AnswersDto answersDto)  ;
    public AnswersDto update(Long id, AnswersDto answersDto)  ;
    public boolean delete(Long id)  ;

}
