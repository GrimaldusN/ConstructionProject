package com.example.construction_project.controller;

import com.example.construction_project.dto.UserAfterCreationDto;
import com.example.construction_project.dto.UserCreateDto;
import com.example.construction_project.entity.Role;
import com.example.construction_project.entity.User;
import com.example.construction_project.security.AuthenticationService;
import com.example.construction_project.security.model.JwtAuthenticationResponse;
import com.example.construction_project.security.model.SignInRequest;
import com.example.construction_project.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private AuthenticationService authenticationService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() throws Exception {
        when(userService.getAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void testCreateUser() throws Exception {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setLogin("Grim");
        userCreateDto.setPassword("password1");
        UserAfterCreationDto userAfterCreationDto = new UserAfterCreationDto();
        userAfterCreationDto.setUserId(UUID.randomUUID().toString());
        userAfterCreationDto.setStatus("User is Created");

        when(passwordEncoder.encode(userCreateDto.getPassword())).thenReturn("encodedPassword");
        when(userService.createUser(any(UserCreateDto.class))).thenReturn(userAfterCreationDto);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userCreateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.username").value("testUser"));
    }

    @Test
    void testGetUserById() throws Exception {
        UUID userId = UUID.randomUUID();
        Role role = new Role();
        role.setId(UUID.randomUUID());
        role.setRoleName("USER_ROLE");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User();
        user.setLogin("testUser");
        user.setPassword("encodedPassword");
        user.setId(userId);
        user.setRoles(roles);

        when(userService.getUserById(userId)).thenReturn(user);

        mockMvc.perform(get("/users/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId.toString()))
                .andExpect(jsonPath("$.username").value("testUser"));
    }

    @Test
    void testDeleteUserById() throws Exception {
        UUID userId = UUID.randomUUID();

        mockMvc.perform(delete("/users/{id}", userId))
                .andExpect(status().isOk());
    }

    @Test
    void testLogin() throws Exception {
        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setLogin("testUser");
        signInRequest.setPassword("password123");
        JwtAuthenticationResponse jwtResponse = new JwtAuthenticationResponse("mockedJwtToken");

        when(authenticationService.authenticate(any(SignInRequest.class))).thenReturn(jwtResponse);

        mockMvc.perform(post("/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signInRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("mockedJwtToken"));
    }
}