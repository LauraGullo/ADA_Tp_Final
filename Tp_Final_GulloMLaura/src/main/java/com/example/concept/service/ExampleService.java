package com.example.concept.service;

import com.example.concept.model.dto.ExampleDto;

import java.util.List;

public interface ExampleService {
    public List<ExampleDto> findAll();
    public ExampleDto save(ExampleDto exampleDto);
    public ExampleDto update(Long id, ExampleDto exampleDto);
    public boolean delete(Long id);
}
