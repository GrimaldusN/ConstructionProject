package com.example._23project.sevice;

import com.example._23project.dto.Building.BuildingAfterCreationDto;
import com.example._23project.dto.Building.BuildingCreateDto;
import com.example._23project.entity.Building;

public interface BuildingService {
    Building getBuildingById(String id);
    Building getBuildingByAddress(String address);
    Building getBuildingByName(String name);
    void deleteBuildingById(String id);
    BuildingAfterCreationDto createBuilding(BuildingCreateDto buildingCreateDto);
}
