package com.example.concept.service;

import com.example.concept.model.dto.ChapterDto;

import java.util.List;

public interface ChapterService {
    public List<ChapterDto> findAll();
    public ChapterDto save(ChapterDto chapterDto);
    public ChapterDto update(Long id, ChapterDto chapterDto);
    public boolean delete(Long id);
}
