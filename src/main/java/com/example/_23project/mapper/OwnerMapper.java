package com.example._23project.mapper;

import com.example._23project.dto.OwnerAfterCreationDto;
import com.example._23project.dto.OwnerCreateDto;
import com.example._23project.entity.Building;
import com.example._23project.entity.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",imports = {Building.class})
public interface OwnerMapper {
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "tellNumber", source = "tellNumber")

    @Mapping(target = "id", ignore = true)
    Owner toEntity(OwnerCreateDto ownerCreateDto);

    @Mapping(target = "ownerId", source = "id")

    @Mapping(target = "status", ignore = true)
    OwnerAfterCreationDto toDto(Owner ownerAfterCreation);
}