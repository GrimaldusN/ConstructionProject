package com.example.construction_project.service;

import com.example.construction_project.dto.BuildingAfterCreationDto;
import com.example.construction_project.dto.BuildingCreateDto;
import com.example.construction_project.entity.Building;

import java.util.UUID;

public interface BuildingService {
    Building getBuildingById(UUID id);
    void deleteBuildingById(UUID id);
    BuildingAfterCreationDto createBuilding(BuildingCreateDto buildingCreateDto);
}
