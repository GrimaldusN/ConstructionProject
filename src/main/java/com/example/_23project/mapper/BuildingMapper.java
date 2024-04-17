package com.example._23project.mapper;

import com.example._23project.dto.BuildingAfterCreationDto;
import com.example._23project.dto.BuildingCreateDto;
import com.example._23project.entity.Building;

public interface BuildingMapper {
    Building toEntity(BuildingCreateDto buildingCreateDto);

    BuildingAfterCreationDto toDto(Building buildingAfterCreation);
}
