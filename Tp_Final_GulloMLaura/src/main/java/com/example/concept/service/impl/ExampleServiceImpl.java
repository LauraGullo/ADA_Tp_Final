package com.example.concept.service.impl;

import com.example.concept.model.dto.ExampleDto;
import com.example.concept.model.entities.Example;
import com.example.concept.model.repositories.ExampleRepository;
import com.example.concept.service.ExampleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private ExampleRepository exampleRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ExampleDto> findAll() {
        List<Example> exampleList = exampleRepository.findAll();
        List<ExampleDto> exampleDtoList = new ArrayList<>();
        for (Example example : exampleList) {
            exampleDtoList.add(modelMapper.map(example, ExampleDto.class));
        }
        return exampleDtoList;
    }

    @Override
    public ExampleDto save(ExampleDto exampleDto) {
        Example example = modelMapper.map(exampleDto, Example.class);
        exampleRepository.save(example);
        return exampleDto;
    }

    @Override
    public ExampleDto update(Long id, ExampleDto exampleDto) {
        Optional<Example> exampleOptional = exampleRepository.findById(id);
        Example example = exampleOptional.get();
        example = modelMapper.map(exampleDto, Example.class);
        example = exampleRepository.save(example);
        return exampleDto;
    }

    @Override
    public boolean delete(Long id) {
        exampleRepository.deleteById(id);
        return true;
    }
}