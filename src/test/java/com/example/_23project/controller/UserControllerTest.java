package com.example._23project.controller;

import com.example._23project.dto.UserAfterCreationDto;
import com.example._23project.dto.UserCreateDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("changelog/schemaTest.sql")
@Sql(value = "changelog/dataTest.sql")
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    public static void beforeAll() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
        Statement statement = connection.createStatement();
        statement.execute("CREATE ALIAS IF NOT EXISTS UUID_TO_BIN FOR \"com.example._23project.utils.UUIDFunction.uuidToBin\"");
    }

    @Test
    public void createUserPositiveTest() throws Exception {
        UserCreateDto dto = new UserCreateDto("Grim");

        String json = objectMapper.writeValueAsString(dto);

        System.out.println("******************************");
        System.out.println(json);
        System.out.println("******************************");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        UserAfterCreationDto userAfterCreationDto = objectMapper.readValue(jsonResult, UserAfterCreationDto.class);

        assertNotNull(userAfterCreationDto.getId());

        System.out.println("******************************");
        System.out.println(jsonResult);
        System.out.println("******************************");
    }
}