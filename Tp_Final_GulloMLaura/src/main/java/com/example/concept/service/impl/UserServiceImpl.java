package com.example.concept.service.impl;

import com.example.concept.model.dto.UserDto;
import com.example.concept.model.entities.User;
import com.example.concept.model.repositories.UserRepository;
import com.example.concept.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<UserDto> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            userDtoList.add(modelMapper.map(user, UserDto.class));
        }
        return userDtoList;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return userDto;
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        user = modelMapper.map(userDto, User.class);
        user = userRepository.save(user);
        return userDto;
    }

    @Override
    public boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}