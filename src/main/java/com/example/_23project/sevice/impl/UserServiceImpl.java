package com.example._23project.sevice.impl;

import com.example._23project.dto.UserAfterCreationDto;
import com.example._23project.dto.UserCreateDto;
import com.example._23project.entity.User;
import com.example._23project.exception.ErrorMessage;
import com.example._23project.exception.UserAlreadyExistException;
import com.example._23project.exception.UserNotExistException;
import com.example._23project.mapper.UserMapper;
import com.example._23project.repository.UserRepository;
import com.example._23project.sevice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public User getUserById(String id) {
        User user = userRepository.getUserById(UUID.fromString(id));
        if (user == null){
            throw new UserNotExistException(ErrorMessage.USER_NOT_EXIST);
        }return user;
    }

    @Override
    public void deleteUserById(String id) {
        User user = userRepository.getUserById(UUID.fromString(id));
        if (user == null){
            throw new UserNotExistException(ErrorMessage.USER_NOT_EXIST);
        }userRepository.deleteUsersById(UUID.fromString(id));
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
