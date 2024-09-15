package com.example.construction_project.controller;

import com.example.construction_project.dto.OwnerAfterCreationDto;
import com.example.construction_project.dto.OwnerCreateDto;
import com.example.construction_project.entity.Owner;
import com.example.construction_project.service.OwnerService;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OwnerController.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerService ownerService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllOwners() throws Exception {
        // Mocking the service response
        when(ownerService.getAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/owner"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void testGetOwnerById() throws Exception {
        UUID ownerId = UUID.randomUUID();
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setTellNumber("1234567890");

        when(ownerService.getOwnerById(ownerId)).thenReturn(owner);

        mockMvc.perform(get("/owner/{id}", ownerId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ownerId.toString()))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.tellNumber").value("123456789"));
    }

    @Test
    void testDeleteOwnerById() throws Exception {
        UUID ownerId = UUID.randomUUID();

        mockMvc.perform(delete("/owner/{id}", ownerId))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateOwnerByTellNumber() throws Exception {
        String oldTellNumber = "123456789";
        String newTellNumber = "987654321";
        UUID ownerId = UUID.randomUUID();
        Owner updatedOwner = new Owner();
        updatedOwner.setId(ownerId);
        updatedOwner.setFirstName("John");
        updatedOwner.setLastName("Doe");
        updatedOwner.setTellNumber("1234567890");

        when(ownerService.updateOwnerByTellNumber(oldTellNumber, newTellNumber)).thenReturn(updatedOwner);

        mockMvc.perform(put("/owner/updateTellNumber")
                        .param("tellNumber", oldTellNumber)
                        .param("newTellNumber", newTellNumber))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tellNumber").value(newTellNumber));
    }

    @Test
    void testCreateOwner() throws Exception {
        // Mocking the service response
        OwnerCreateDto ownerCreateDto = new OwnerCreateDto();
        ownerCreateDto.setFirstName("John");
        ownerCreateDto.setLastName("Doe");
        ownerCreateDto.setTellNumber("1234567890");
        OwnerAfterCreationDto ownerAfterCreationDto = new OwnerAfterCreationDto();
        UUID ownerId = UUID.randomUUID();
        ownerAfterCreationDto.setOwnerId(String.valueOf(ownerId));
        ownerAfterCreationDto.setStatus("Owner is created");

        when(ownerService.createOwner(any(OwnerCreateDto.class))).thenReturn(ownerAfterCreationDto);

        mockMvc.perform(post("/owner")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ownerCreateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }
}
