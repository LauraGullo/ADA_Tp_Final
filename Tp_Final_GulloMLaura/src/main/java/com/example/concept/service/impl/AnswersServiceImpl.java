package com.example.concept.service.impl;

import com.example.concept.model.dto.AnswersDto;
import com.example.concept.model.entities.Answers;
import com.example.concept.model.repositories.AnswersRepository;
import com.example.concept.service.AnswersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswersServiceImpl implements AnswersService<Answers>{
    @Autowired
    private AnswersRepository answersRepository;
    ModelMapper modelMapper=new ModelMapper();

    @Override
    public List<AnswersDto> findAll() {
            List<Answers> answersList=answersRepository.findAll();
            List<AnswersDto>answersDtoList=new ArrayList<>();
            for(Answers answers: answersList ){
               answersDtoList.add(modelMapper.map(answers, AnswersDto.class));
            }
            return answersDtoList;
    }

    @Override
    public AnswersDto save(AnswersDto answersDto)  {
            Answers answers=modelMapper.map(answersDto, Answers.class);
            answersRepository.save(answers);
            return answersDto;
    }

    @Override
    public AnswersDto update(Long id, AnswersDto answersDto)  {
            Optional<Answers> answersOptional=answersRepository.findById(id);
            Answers answers=answersOptional.get();
            answers=modelMapper.map(answersDto, Answers.class);
            answersRepository.save(answers);
            return answersDto;
    }

    @Override
    public boolean delete(Long id)  {
           answersRepository.deleteById(id);
           return true;
    }




}

