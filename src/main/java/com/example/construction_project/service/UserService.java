package com.example.construction_project.service;

import com.example.construction_project.dto.UserAfterCreationDto;
import com.example.construction_project.dto.UserCreateDto;
import com.example.construction_project.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> getAll();
    User getUserById(UUID id);
    void deleteUserById(UUID id);
    Optional<User> findByLogin(String login);

    UserAfterCreationDto createUser(UserCreateDto userCreateDto);
}
