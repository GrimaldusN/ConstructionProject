package com.example._23project.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.UUID;
import com.example._23project.dto.OwnerAfterCreationDto;
import com.example._23project.dto.OwnerCreateDto;
import com.example._23project.entity.Owner;
import com.example._23project.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = {"/db/changelog/schemaTest.sql", "/db/changelog/dataTest.sql"})
public class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerService ownerService;

    private UUID ownerId;
    private Owner owner;
    private OwnerAfterCreationDto ownerAfterCreationDto;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        ownerId = UUID.randomUUID();
        owner = new Owner();
        owner.setId(ownerId);
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setTellNumber(123456789);

        ownerAfterCreationDto = new OwnerAfterCreationDto();
        ownerAfterCreationDto.setOwnerId(ownerId.toString());
    }

    @Test
    public void testGetOwnerById() throws Exception {
        when(ownerService.getOwnerById(ownerId)).thenReturn(owner);

        mockMvc.perform(get("/owner/get/{id}", ownerId))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":\"" + ownerId + "\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"tellNumber\":123456789}"));

        verify(ownerService).getOwnerById(ownerId);
    }

    @Test
    public void testDeleteOwnerById() throws Exception {
        doNothing().when(ownerService).deleteOwnerById(ownerId);

        mockMvc.perform(delete("/owner/delete/{id}", ownerId))
                .andExpect(status().isOk());

        verify(ownerService).deleteOwnerById(ownerId);
    }

    @Test
    public void testUpdateOwnerByTellNumber() throws Exception {
        int tellNumber = 123456789;
        int newTellNumber = 987654321;
        when(ownerService.updateOwnerByTellNumber(tellNumber, newTellNumber)).thenReturn(owner);

        mockMvc.perform(put("/owner/owners/updateByTellNumber")
                        .param("tellNumber", String.valueOf(tellNumber))
                        .param("newTellNumber", String.valueOf(newTellNumber)))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":\"" + ownerId + "\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"tellNumber\":123456789}"));

        verify(ownerService).updateOwnerByTellNumber(tellNumber, newTellNumber);
    }

    @Test
    public void testCreateOwner() throws Exception {
        when(ownerService.createOwner(any(OwnerCreateDto.class))).thenReturn(ownerAfterCreationDto);

        mockMvc.perform(post("/owner/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"Jane\",\"lastName\":\"Smith\",\"tellNumber\":987654321}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"ownerId\":\"" + ownerId + "\",\"status\":\"Owner is Created\"}"));

        verify(ownerService).createOwner(any(OwnerCreateDto.class));
    }
}
