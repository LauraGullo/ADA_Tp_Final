package com.example.concept.service;

import com.example.concept.model.dto.UserDto;

import java.util.List;
public interface UserService {
    public List<UserDto> findAll();
    public UserDto save(UserDto userDto);
    public UserDto update(Long id, UserDto userDto);
    public boolean delete(Long id);
}
