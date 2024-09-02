package com.example.construction_project.service.impl;

import com.example.construction_project.dto.UserAfterCreationDto;
import com.example.construction_project.dto.UserCreateDto;
import com.example.construction_project.entity.User;
import com.example.construction_project.exception.ErrorMessage;
import com.example.construction_project.exception.UserAlreadyExistException;
import com.example.construction_project.exception.UserNotExistException;
import com.example.construction_project.exception.UsersEmpty;
import com.example.construction_project.mapper.UserMapper;
import com.example.construction_project.repository.UserRepository;
import com.example.construction_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        if (users == null){
            throw new UsersEmpty(ErrorMessage.USERS_EMPTY);
        }return users;
    }

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
    public Optional<User> findByLogin(String login) {
        return Optional.ofNullable(userRepository.findUserByLogin(login));
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
