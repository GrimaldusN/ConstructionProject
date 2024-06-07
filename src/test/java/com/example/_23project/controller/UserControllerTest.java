package com.example._23project.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.UUID;
import com.example._23project.dto.UserAfterCreationDto;
import com.example._23project.dto.UserCreateDto;
import com.example._23project.entity.User;
import com.example._23project.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql("/db/changelog/changes/v0.0.1-SNAPSHOT/schemaTest.xml")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserController userController;

    private UUID userId;
    private User user;
    private UserCreateDto userCreateDto;
    private UserAfterCreationDto userAfterCreationDto;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userId = UUID.randomUUID();
        user = new User();
        user.setId(userId);
        user.setLogin("alice_johnson");

        userCreateDto = new UserCreateDto("alice_johnson");

        userAfterCreationDto = new UserAfterCreationDto();
        userAfterCreationDto.setId(userId.toString());
    }

    @Test
    public void testCreateUser() throws Exception {
        when(userService.createUser(any(UserCreateDto.class))).thenReturn(userAfterCreationDto);

        mockMvc.perform(post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"login\":\"alice_johnson\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"userId\":\"" + userId + "\",\"status\":\"User is Created\"}"));

        verify(userService).createUser(any(UserCreateDto.class));
    }

    @Test
    public void testGetUserById() throws Exception {
        when(userService.getUserById(userId)).thenReturn(user);

        mockMvc.perform(get("/user/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":\"" + userId + "\",\"login\":\"alice_johnson\"}"));

        verify(userService).getUserById(userId);
    }

    @Test
    public void testDeleteUserById() throws Exception {
        doNothing().when(userService).deleteUserById(userId);

        mockMvc.perform(delete("/user/{id}", userId))
                .andExpect(status().isOk());

        verify(userService).deleteUserById(userId);
    }
}
