package com.example._23project.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.UUID;
import com.example._23project.dto.BuildingAfterCreationDto;
import com.example._23project.dto.BuildingCreateDto;
import com.example._23project.entity.Building;
import com.example._23project.service.BuildingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
@Sql("db.changelog/schemaTest.sql")
@Sql("db.changelog/dataTest.sql")
public class BuildingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BuildingService buildingService;

    private UUID buildingId;
    private Building building;
    private BuildingAfterCreationDto buildingAfterCreationDto;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
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
                        .content("{\"cost\":\"150000000\",\"address\":\"350 5th Ave, New York, NY 10118, USA\",\"ownerName\":\"John Doe\",\"name\":\"Empire State Building\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"buildingId\":\"" + buildingId + "\",\"status\":\"Building is Created\"}"));

        verify(buildingService).createBuilding(any(BuildingCreateDto.class));
    }
}
