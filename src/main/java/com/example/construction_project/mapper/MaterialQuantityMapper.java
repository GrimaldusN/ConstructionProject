package com.example.construction_project.mapper;

import com.example.construction_project.dto.MaterialQuantityAfterCreationDto;
import com.example.construction_project.dto.MaterialQuantityCreateDto;
import com.example.construction_project.entity.Material_quantity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OwnerMapper.class} )
public interface MaterialQuantityMapper {
    @Mapping(target = "building.name", source = "buildingName")
    @Mapping(target = "building.address", source = "address")
    @Mapping(target = "building.owner.firstName", source = "firstName")
    @Mapping(target = "building.owner.lastName", source = "lastName")
    @Mapping(target = "building.owner.tellNumber", source = "tellNumber")
    @Mapping(target = "material.name", source = "materialName")
    @Mapping(target = "material.cost", source = "materialCost")
    @Mapping(target = "quantity", source = "quantity")
    Material_quantity toEntity(MaterialQuantityCreateDto materialQuantityCreateDto);

    @Mapping(target = "materialQuantityId", source = "id")
    MaterialQuantityAfterCreationDto toDto(Material_quantity materialQuantityAfterCreation);
}
