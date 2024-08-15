package com.example.construction_project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.UUID;
import com.example.construction_project.dto.UserAfterCreationDto;
import com.example.construction_project.dto.UserCreateDto;
import com.example.construction_project.entity.User;
import com.example.construction_project.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"/db/changelog/schemaTest.sql", "/db/changelog/dataTest.sql"})
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserServiceImpl userService;

    private UUID userId;
    private User user;
    private UserAfterCreationDto userAfterCreationDto;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userId = UUID.randomUUID();
        user = new User();
        user.setId(userId);
        user.setLogin("alice_johnson");

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

        String json = objectMapper.writeValueAsString(user);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", userId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(json))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertEquals(json, result.getResponse().getContentAsString());
    }

    @Test
    public void testDeleteUserById() throws Exception {
        doNothing().when(userService).deleteUserById(userId);

        mockMvc.perform(delete("/user/{id}", userId))
                .andExpect(status().isOk());

        verify(userService).deleteUserById(userId);
    }
}