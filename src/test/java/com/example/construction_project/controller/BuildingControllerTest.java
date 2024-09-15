package com.example.construction_project.controller;

import com.example.construction_project.dto.BuildingAfterCreationDto;
import com.example.construction_project.dto.BuildingCreateDto;
import com.example.construction_project.entity.Building;
import com.example.construction_project.service.BuildingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BuildingController.class)
class BuildingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuildingService buildingService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBuildings() throws Exception {
        when(buildingService.getAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/building"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void testGetBuildingById() throws Exception {
        UUID buildingId = UUID.randomUUID();
        Building building = new Building();
        building.setId(buildingId);
        building.setName("Office Building");
        building.setAddress("123 Main St");
        building.setCost(12008.00);

        when(buildingService.getBuildingById(buildingId)).thenReturn(building);

        mockMvc.perform(get("/building/{id}", buildingId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(buildingId.toString()))
                .andExpect(jsonPath("$.name").value("Office Building"))
                .andExpect(jsonPath("$.address").value("123 Main St"));
    }

    @Test
    void testDeleteBuildingById() throws Exception {
        UUID buildingId = UUID.randomUUID();

        mockMvc.perform(delete("/building/{id}", buildingId))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateBuilding() throws Exception {
        // Mocking the service response
        BuildingCreateDto buildingCreateDto = new BuildingCreateDto();
        buildingCreateDto.setName("Office Building");
        buildingCreateDto.setAddress("123 Main St");
        buildingCreateDto.setCost(12000.00);
        BuildingAfterCreationDto buildingAfterCreationDto = new BuildingAfterCreationDto();
        buildingAfterCreationDto.setBuildingId(UUID.randomUUID().toString());
        buildingAfterCreationDto.setStatus("Building is created");

        when(buildingService.createBuilding(any(BuildingCreateDto.class))).thenReturn(buildingAfterCreationDto);

        mockMvc.perform(post("/building")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildingCreateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Office Building"));
    }
}
