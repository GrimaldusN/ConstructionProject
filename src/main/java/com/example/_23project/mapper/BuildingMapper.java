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
    @Mapping(target = "address.street", source = "addressName")
    @Mapping(target = "owner.firstName", source = "ownerName")

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "materials", ignore = true)
    @Mapping(target = "builders", ignore = true)
    Building toEntity(BuildingCreateDto buildingCreateDto);

    @Mapping(target ="buildingId", source = "id")
    BuildingAfterCreationDto toDto(Building buildingAfterCreation);
}
