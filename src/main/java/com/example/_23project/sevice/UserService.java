package com.example._23project.sevice;

import com.example._23project.dto.UserAfterCreationDto;
import com.example._23project.dto.UserCreateDto;
import com.example._23project.entity.User;

public interface UserService {
    User getUserById(String id);
    void deleteUserById(String id);

    UserAfterCreationDto createUser(UserCreateDto userCreateDto);
}
