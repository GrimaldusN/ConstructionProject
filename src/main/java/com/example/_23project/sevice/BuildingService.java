package com.example._23project.sevice;

import com.example._23project.dto.BuildingAfterCreationDto;
import com.example._23project.dto.BuildingCreateDto;
import com.example._23project.entity.Building;

import java.util.List;

public interface BuildingService {
    Building getBuildingById(String id);
    Building getBuildingByAddressName(String addressName);
    void deleteBuildingById(String id);


    BuildingAfterCreationDto createBuilding(BuildingCreateDto buildingCreateDto);
}
