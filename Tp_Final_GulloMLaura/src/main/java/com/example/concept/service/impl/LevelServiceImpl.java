package com.example.concept.service.impl;

import com.example.concept.model.dto.LevelDto;
import com.example.concept.model.entities.Level;
import com.example.concept.model.repositories.LevelRepository;
import com.example.concept.service.LevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelRepository levelRepository;

    ModelMapper modelMapper=new ModelMapper();

    @Override
    public List<LevelDto> findAll() {

        List<Level> levelList=levelRepository.findAll();
        List<LevelDto>levelDtoList=new ArrayList<>();
        for(Level level: levelList ){
            levelDtoList.add(modelMapper.map(level, LevelDto.class));
        }
        return levelDtoList;
    }

    @Override
    public LevelDto save(LevelDto levelDto)  {

        Level level=modelMapper.map(levelDto, Level.class);
        levelRepository.save(level);
        return levelDto;
    }

    @Override
    public LevelDto update(Long id, LevelDto levelDto)  {

        Optional<Level> levelOptional=levelRepository.findById(id);
        Level level=levelOptional.get();
        level=modelMapper.map(levelDto, Level.class);
        levelRepository.save(level);
        return levelDto;
    }

    @Override
    public boolean delete(Long id)  {

        levelRepository.deleteById(id);
        return true;
    }


}
