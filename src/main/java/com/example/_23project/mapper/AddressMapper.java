package com.example._23project.mapper;

import com.example._23project.dto.AddressAfterCreationDto;
import com.example._23project.dto.AddressCreateDto;
import com.example._23project.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    @Mapping(target = "street", source = "street")
    @Mapping(target = "number", source = "number")

    @Mapping(target = "addressId", ignore = true)
    Address toEntity(AddressCreateDto addressCreateDto);

    @Mapping(target = "addressId", source = "addressId")
    AddressAfterCreationDto toDto(Address addressAfterCreation);
}
