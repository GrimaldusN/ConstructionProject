package com.example.construction_project.mapper;

import com.example.construction_project.dto.BuildingAfterCreationDto;
import com.example.construction_project.dto.BuildingCreateDto;
import com.example.construction_project.entity.Building;
import com.example.construction_project.entity.Owner;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {OwnerMapper.class} )
public interface BuildingMapper {
    @Mapping(target = "cost", source = "cost")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "owner.firstName", source = "firstName")
    @Mapping(target = "owner.lastName", source = "lastName")
    @Mapping(target = "owner.tellNumber", source = "tellNumber")
    @Mapping(target = "name", source = "name")
    Building toEntity(BuildingCreateDto buildingCreateDto);

    @AfterMapping
    default void createdOwnerInfo(@MappingTarget Building building, BuildingCreateDto buildingCreateDto){
        Owner owner = new Owner();
        owner.setFirstName(buildingCreateDto.getFirstName());
        owner.setLastName(buildingCreateDto.getLastName());
        owner.setTellNumber(buildingCreateDto.getTellNumber());
        building.setOwner(owner);
    }

    @Mapping(target ="buildingId", source = "id")
    BuildingAfterCreationDto toDto(Building buildingAfterCreation);
}

