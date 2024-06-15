package com.example.construction_project.mapper;

import com.example.construction_project.dto.OwnerAfterCreationDto;
import com.example.construction_project.dto.OwnerCreateDto;
import com.example.construction_project.entity.Building;
import com.example.construction_project.entity.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",imports = {Building.class})
public interface OwnerMapper {
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "tellNumber", source = "tellNumber")
    Owner toEntity(OwnerCreateDto ownerCreateDto);

    @Mapping(target = "ownerId", source = "id")
    OwnerAfterCreationDto toDto(Owner ownerAfterCreation);
}