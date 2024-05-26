package com.example._23project.service;

import com.example._23project.dto.UserAfterCreationDto;
import com.example._23project.dto.UserCreateDto;
import com.example._23project.entity.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
    void deleteUserById(UUID id);

    UserAfterCreationDto createUser(UserCreateDto userCreateDto);
}
