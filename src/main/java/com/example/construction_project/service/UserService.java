package com.example.construction_project.service;

import com.example.construction_project.dto.UserAfterCreationDto;
import com.example.construction_project.dto.UserCreateDto;
import com.example.construction_project.entity.User;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> origin/test
import java.util.UUID;

public interface UserService {
    List<User> getAll();
    User getUserById(UUID id);
    void deleteUserById(UUID id);
<<<<<<< HEAD
    Optional<User> findByLogin(String login);
=======
>>>>>>> origin/test

    UserAfterCreationDto createUser(UserCreateDto userCreateDto);
}
