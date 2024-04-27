package com.example._23project.mapper;

import com.example._23project.dto.Building.BuildingAfterCreationDto;
import com.example._23project.dto.Building.BuildingCreateDto;
import com.example._23project.entity.Building;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BuildingMapper {
    @Mapping(target = "cost", source = "cost")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "owner.firstName", source = "ownerName")
    @Mapping(target = "name", source = "name")

    @Mapping(target = "id", ignore = true)
    Building toEntity(BuildingCreateDto buildingCreateDto);

    @Mapping(target ="buildingId", source = "id")

    @Mapping(target = "status", ignore = true)
    BuildingAfterCreationDto toDto(Building buildingAfterCreation);
}
