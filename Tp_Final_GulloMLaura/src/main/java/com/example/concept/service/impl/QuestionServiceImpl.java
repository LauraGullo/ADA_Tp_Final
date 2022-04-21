package com.example.concept.service.impl;

import com.example.concept.model.dto.QuestionDto;
import com.example.concept.model.entities.Question;
import com.example.concept.model.repositories.QuestionRepository;
import com.example.concept.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService <Question> {

    @Autowired
    private QuestionRepository questionRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<QuestionDto> findAll() {
        List<Question> questionList = questionRepository.findAll();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question question : questionList) {
            questionDtoList.add(modelMapper.map(question, QuestionDto.class));
        }
        return questionDtoList;
    }

    @Override
    public QuestionDto save(QuestionDto questionDto) {
        Question question = modelMapper.map(questionDto, Question.class);
        questionRepository.save(question);
        return questionDto;
    }

    @Override
    public QuestionDto update(Long id, QuestionDto questionDto) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        Question question = questionOptional.get();
        question = modelMapper.map(questionDto, Question.class);
        question = questionRepository.save(question);
        return questionDto;
    }

    @Override
    public boolean delete(Long id) {
        questionRepository.deleteById(id);
        return true;
    }
}
