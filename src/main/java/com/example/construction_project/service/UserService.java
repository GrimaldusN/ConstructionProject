package com.example.construction_project.service;

import com.example.construction_project.dto.UserAfterCreationDto;
import com.example.construction_project.dto.UserCreateDto;
import com.example.construction_project.entity.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
    void deleteUserById(UUID id);

    UserAfterCreationDto createUser(UserCreateDto userCreateDto);
}
