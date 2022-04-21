package com.example.concept.service.impl;

import com.example.concept.ConceptApplication;
import com.example.concept.model.dto.AnswersDto;
import com.example.concept.model.dto.QuestionDto;
import com.example.concept.model.entities.Answers;
import com.example.concept.model.entities.Question;
import com.example.concept.model.repositories.AnswersRepository;
import com.example.concept.model.repositories.QuestionRepository;
import com.example.concept.service.QuestionaryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionaryServiceImpl implements QuestionaryService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswersRepository answersRepository;

    ModelMapper modelMapper = new ModelMapper();

    private static final Logger logger= LoggerFactory.getLogger(ConceptApplication.class);

    @Override
    public Boolean validateAnswer(Long idAnswers, Long idQuestion) {
        List<Answers> answersList = answersRepository.findAllByIdAnswersAndIdQuestion(idAnswers, idQuestion);
        List<AnswersDto> answersDtoList = new ArrayList<>();
        for (Answers answers : answersList) {
            answersDtoList.add(modelMapper.map(answers, AnswersDto.class));
        }
        if (answersDtoList.isEmpty()) {
            logger.info("Respuesta no valida para el id pregunta");
            return false;
        } else {
            logger.info("Respuesta valida para el id pregunta");
            return true;
        }
    }

    @Override
    public boolean validateCorrectAnswer(Long id){
        Optional<Answers> answers=answersRepository.findById(id);
        logger.info("Validando respuesta correcta");
        return answers.get().isItsCorrect();
    }

    @Override
    public List<QuestionDto> findAllByIdConcept(Long id) {
        List<Question> questionList=questionRepository.findAllByIdConcept(id);
        List<QuestionDto>questionDtoList=new ArrayList<>();
        for(Question question: questionList ){
            questionDtoList.add(modelMapper.map(question, QuestionDto.class));
        }
        return questionDtoList;
    }
}
