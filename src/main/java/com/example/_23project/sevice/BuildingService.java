package com.example._23project.sevice;

import com.example._23project.dto.BuildingAfterCreationDto;
import com.example._23project.dto.BuildingCreateDto;
import com.example._23project.entity.Building;

public interface BuildingService {
    Building getBuildingById(String id);
    void deleteBuildingById(String id);
    BuildingAfterCreationDto createBuilding(BuildingCreateDto buildingCreateDto);
}
