package com.example.concept.service.impl;

import com.example.concept.ConceptApplication;
import com.example.concept.model.dto.ConceptDto;
import com.example.concept.model.entities.Concept;
import com.example.concept.model.repositories.ConceptRepository;
import com.example.concept.service.ConceptService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConceptServiceImpl implements ConceptService<Concept> {

    @Autowired
    private ConceptRepository conceptRepository;

    ModelMapper modelMapper=new ModelMapper();

    private static final Logger logger= LoggerFactory.getLogger(ConceptApplication.class);

    @Override
    public List<ConceptDto> findAll() {

            List<Concept> conceptList=conceptRepository.findAll();
            List<ConceptDto>conceptDtoList=new ArrayList<>();
            for(Concept concept: conceptList ){
                conceptDtoList.add(modelMapper.map(concept, ConceptDto.class));
            }
            return conceptDtoList;
    }

    @Override
    public ConceptDto save(ConceptDto conceptDto)  {

            Concept concept=modelMapper.map(conceptDto, Concept.class);
            conceptRepository.save(concept);
            return conceptDto;
    }

    @Override
    public ConceptDto update(Long id, ConceptDto conceptDto)  {

            Optional<Concept>conceptOptional=conceptRepository.findById(id);
            Concept concept=conceptOptional.get();
            concept=modelMapper.map(conceptDto, Concept.class);
            conceptRepository.save(concept);
            return conceptDto;
    }

    @Override
    public boolean delete(Long id)  {

           conceptRepository.deleteById(id);
           return true;
    }

    @Override
    public ConceptDto getAdvice() {

            long indice = (long)(Math.random() * (conceptRepository.count() - 1) + 1);
            Optional<Concept> response=  conceptRepository.findById(indice);
            ConceptDto concept=modelMapper.map(response, ConceptDto.class);
            logger.info("Consejo aleatorio entregado");
            return concept;
    }
}
