package com.example._23project.mapper;

import com.example._23project.dto.Owner.OwnerAfterCreationDto;
import com.example._23project.dto.Owner.OwnerCreateDto;
import com.example._23project.entity.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
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
