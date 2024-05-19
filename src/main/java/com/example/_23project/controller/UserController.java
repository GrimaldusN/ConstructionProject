package com.example._23project.controller;

import com.example._23project.dto.UserAfterCreationDto;
import com.example._23project.dto.UserCreateDto;
import com.example._23project.entity.User;
import com.example._23project.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") String id){
        userService.deleteUserById(id);
    }

    @PostMapping("/create")
    public UserAfterCreationDto createUser(@RequestBody UserCreateDto userCreateDto){
        return userService.createUser(userCreateDto);
    }
}
