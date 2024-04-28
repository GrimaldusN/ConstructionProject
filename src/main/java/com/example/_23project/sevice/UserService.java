package com.example._23project.sevice;

import com.example._23project.entity.User;

public interface UserService {
    User getUserById(String id);
    void deleteUserById(String id);
}
