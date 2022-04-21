package com.example.concept.service;

import com.example.concept.model.dto.ConceptDto;
import com.example.concept.model.dto.LevelDto;

import java.util.List;

public interface LevelService {
    public List<LevelDto> findAll();
    public LevelDto save(LevelDto levelDto);
    public LevelDto update(Long id, LevelDto levelDto);
    public boolean delete(Long id);
}
