package com.example._23project.mapper;

import com.example._23project.dto.BuildingAfterCreationDto;
import com.example._23project.dto.BuildingCreateDto;
import com.example._23project.entity.Building;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BuildingMapper {
    Building toEntity(BuildingCreateDto buildingCreateDto);

    BuildingAfterCreationDto toDto(Building buildingAfterCreation);
}
