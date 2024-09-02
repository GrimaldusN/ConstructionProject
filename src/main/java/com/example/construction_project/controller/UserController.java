package com.example.construction_project.controller;

import com.example.construction_project.dto.UserAfterCreationDto;
import com.example.construction_project.dto.UserCreateDto;
import com.example.construction_project.entity.User;
import com.example.construction_project.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.security.crypto.password.PasswordEncoder;
=======
>>>>>>> origin/test
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
<<<<<<< HEAD

    private final PasswordEncoder passwordEncoder;
=======
>>>>>>> origin/test
    @GetMapping
    public List<User> getAll(){
        return new ArrayList<>(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<UserAfterCreationDto> createUser(@RequestBody UserCreateDto userCreateDto) {
        UserAfterCreationDto createdUser = userService.createUser(userCreateDto);
<<<<<<< HEAD
        userCreateDto.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
=======
>>>>>>> origin/test
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") UUID id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") UUID id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}

