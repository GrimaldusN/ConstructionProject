package com.example._23project.sevice;

import com.example._23project.dto.BuildingAfterCreationDto;
import com.example._23project.dto.BuildingCreateDto;
import com.example._23project.entity.Building;

import java.util.UUID;

public interface BuildingService {
    Building getBuildingById(UUID id);
    void deleteBuildingById(UUID id);
    BuildingAfterCreationDto createBuilding(BuildingCreateDto buildingCreateDto);
}
