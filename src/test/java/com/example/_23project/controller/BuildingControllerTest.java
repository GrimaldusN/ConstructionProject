package com.example._23project.controller;
import java.util.UUID;

import com.example._23project.dto.BuildingAfterCreationDto;
import com.example._23project.dto.BuildingCreateDto;
import com.example._23project.entity.Building;
import com.example._23project.service.BuildingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = {"/db/changelog/schemaTest.sql", "/db/changelog/dataTest.sql"})
public class BuildingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuildingService buildingService;

    private UUID buildingId;
    private Building building;
    private BuildingAfterCreationDto buildingAfterCreationDto;

    @BeforeEach
    public void setup() {
        buildingId = UUID.randomUUID();
        building = new Building();
        building.setId(buildingId);
        building.setCost(150000000);
        building.setAddress("350 5th Ave, New York, NY 10118, USA");
        building.setName("Empire State Building");

        buildingAfterCreationDto = new BuildingAfterCreationDto();
        buildingAfterCreationDto.setBuildingId(buildingId.toString());
    }

    @Test
    public void testGetBuildingById() throws Exception {
        when(buildingService.getBuildingById(buildingId)).thenReturn(building);

        mockMvc.perform(get("/get/{id}", buildingId))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":\"" + buildingId + "\",\"cost\":150000000,\"address\":\"350 5th Ave, New York, NY 10118, USA\",\"name\":\"Empire State Building\"}"));

        verify(buildingService).getBuildingById(buildingId);
    }

    @Test
    public void testDeleteBuildingById() throws Exception {
        doNothing().when(buildingService).deleteBuildingById(buildingId);

        mockMvc.perform(delete("/delete/{id}", buildingId))
                .andExpect(status().isOk());

        verify(buildingService).deleteBuildingById(buildingId);
    }

    @Test
    public void testCreateBuilding() throws Exception {
        when(buildingService.createBuilding(any(BuildingCreateDto.class))).thenReturn(buildingAfterCreationDto);

        mockMvc.perform(post("/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cost\":150000000,\"address\":\"350 5th Ave, New York, NY 10118, USA\",\"ownerName\":\"John Doe\",\"name\":\"Empire State Building\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"buildingId\":\"" + buildingId + "\",\"status\":\"Building is Created\"}"));

        verify(buildingService).createBuilding(any(BuildingCreateDto.class));
    }
}
