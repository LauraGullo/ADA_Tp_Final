package com.example.concept.service.impl;

import com.example.concept.model.dto.ChapterDto;
import com.example.concept.model.entities.Chapter;
import com.example.concept.model.repositories.ChapterRepository;
import com.example.concept.service.ChapterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    ModelMapper modelMapper=new ModelMapper();

    @Override
    public List<ChapterDto> findAll() {

        List<Chapter> chapterList=chapterRepository.findAll();
        List<ChapterDto>chapterDtoList=new ArrayList<>();
        for(Chapter chapter: chapterList ){
            chapterDtoList.add(modelMapper.map(chapter, ChapterDto.class));
        }
        return chapterDtoList;
    }

    @Override
    public ChapterDto save(ChapterDto chapterDto)  {

        Chapter chapter=modelMapper.map(chapterDto, Chapter.class);
        chapterRepository.save(chapter);
        return chapterDto;
    }

    @Override
    public ChapterDto update(Long id, ChapterDto chapterDto)  {

        Optional<Chapter> chapterOptional=chapterRepository.findById(id);
        Chapter chapter=chapterOptional.get();
        chapter=modelMapper.map(chapterDto, Chapter.class);
        chapterRepository.save(chapter);
        return chapterDto;
    }

    @Override
    public boolean delete(Long id)  {

        chapterRepository.deleteById(id);
        return true;
    }
}
