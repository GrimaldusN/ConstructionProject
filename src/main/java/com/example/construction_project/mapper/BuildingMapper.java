package com.example.construction_project.mapper;

import com.example.construction_project.dto.BuildingAfterCreationDto;
import com.example.construction_project.dto.BuildingCreateDto;
import com.example.construction_project.entity.Building;
import com.example.construction_project.entity.Material;
import com.example.construction_project.entity.Material_quantity;
import com.example.construction_project.entity.Owner;
import com.example.construction_project.repository.BuildingRepository;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {OwnerMapper.class} )
public interface BuildingMapper {
    @Mapping(target = "cost", source = "cost")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "owner.firstName", source = "firstName")
    @Mapping(target = "owner.lastName", source = "lastName")
    @Mapping(target = "owner.tellNumber", source = "tellNumber")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "material_quantity.material.name", source = "material_name")
    @Mapping(target = "material_quantity.quantity", source = "material_quantity")
    @Mapping(target = "material_quantity.building", ignore = true)
    Building toEntity(BuildingCreateDto buildingCreateDto);

    @Mapping(target ="buildingId", source = "id")
    BuildingAfterCreationDto toDto(Building buildingAfterCreation);
}

