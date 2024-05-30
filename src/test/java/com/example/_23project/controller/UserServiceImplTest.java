package com.example._23project.controller;

import com.example._23project.dto.UserAfterCreationDto;
import com.example._23project.dto.UserCreateDto;
import com.example._23project.entity.User;
import com.example._23project.mapper.UserMapper;
import com.example._23project.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql("/db/changelog/changes/v0.0.1-SNAPSHOT/schemaTest.xml")
public class UserServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void createUserPositiveTest() throws Exception {
        UserCreateDto dto = new UserCreateDto("Grim");

        String json = objectMapper.writeValueAsString(dto);

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setLogin(dto.getLogin());

        UserAfterCreationDto userAfterCreationDto = new UserAfterCreationDto();
        userAfterCreationDto.setId(user.getId());
        userAfterCreationDto.setStatus("User is Created");

        when(userRepository.findUserByLogin(dto.getLogin())).thenReturn(null);
        when(userMapper.toEntity(dto)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.toDto(user)).thenReturn(userAfterCreationDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        UserAfterCreationDto resultDto = objectMapper.readValue(jsonResult, UserAfterCreationDto.class);

        assertNotNull(resultDto.getId());

        System.out.println("******************************");
        System.out.println(jsonResult);
        System.out.println("******************************");
    }

    @Test
    public void getUserByIdTest() throws Exception {
        UUID userId = UUID.randomUUID();
        User user = new User();
        user.setId(userId);
        user.setLogin("Grim");

        when(userRepository.getUserById(userId)).thenReturn(user);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", userId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        User resultUser = objectMapper.readValue(jsonResult, User.class);

        assertEquals(userId, resultUser.getId());

        System.out.println("******************************");
        System.out.println(jsonResult);
        System.out.println("******************************");
    }

    @Test
    public void deleteUserByIdTest() throws Exception {
        UUID userId = UUID.randomUUID();
        User user = new User();
        user.setId(userId);
        user.setLogin("Grim");

        when(userRepository.getUserById(userId)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.delete("/user/{id}", userId))
                .andExpect(status().isOk());

        verify(userRepository, times(1)).deleteUsersById(userId);

        System.out.println("******************************");
        System.out.println("User with ID: " + userId + " deleted");
        System.out.println("******************************");
    }
}