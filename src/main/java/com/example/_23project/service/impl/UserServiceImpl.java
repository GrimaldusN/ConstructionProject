package com.example._23project.service.impl;

import com.example._23project.dto.UserAfterCreationDto;
import com.example._23project.dto.UserCreateDto;
import com.example._23project.entity.User;
import com.example._23project.exception.ErrorMessage;
import com.example._23project.exception.UserAlreadyExistException;
import com.example._23project.exception.UserNotExistException;
import com.example._23project.mapper.UserMapper;
import com.example._23project.repository.UserRepository;
import com.example._23project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public User getUserById(UUID id) {
        User user = userRepository.getUserById(id);
        if (user == null){
            throw new UserNotExistException(ErrorMessage.USER_NOT_EXIST);
        }return user;
    }

    @Override
    public void deleteUserById(UUID id) {
        User user = userRepository.getUserById(id);
        if (user == null){
            throw new UserNotExistException(ErrorMessage.USER_NOT_EXIST);
        }userRepository.deleteUsersById(id);
        System.out.println("User with ID: " + id + " are deleted");
    }

    @Override
    public UserAfterCreationDto createUser(UserCreateDto userCreateDto) {
        User user = userRepository.findUserByLogin(userCreateDto.getLogin());
        if (user != null){
            throw new UserAlreadyExistException(ErrorMessage.USER_ALREADY_EXIST);
        }
        User entity = userMapper.toEntity(userCreateDto);
        User userAfterCreation = userRepository.save(entity);
        return userMapper.toDto(userAfterCreation);
    }
}
