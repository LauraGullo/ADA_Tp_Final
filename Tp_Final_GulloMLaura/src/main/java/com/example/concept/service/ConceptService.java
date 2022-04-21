package com.example.concept.service;

import com.example.concept.model.dto.ConceptDto;

import java.util.List;

public interface ConceptService<E>{
    public List<ConceptDto> findAll();
    public ConceptDto save(ConceptDto conceptDto);
    public ConceptDto update(Long id, ConceptDto conceptDto);
    public boolean delete(Long id);
    public ConceptDto getAdvice();

}
