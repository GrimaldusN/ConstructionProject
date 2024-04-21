package com.example._23project.mapper;

import com.example._23project.dto.Builder.BuilderAfterCreationDto;
import com.example._23project.dto.Builder.BuilderCreateDto;
import com.example._23project.entity.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BuilderMapper {
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "tellNumber", source = "tellNumber")

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "building", ignore = true)
    Builder toEntity(BuilderCreateDto builderCreateDto);
    @Mapping(target = "builderId", source = "id")

    @Mapping(target = "status", ignore = true)
    BuilderAfterCreationDto toDto(Builder builderAfterCreation);
}
