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
//    @Mapping(target = "material.name", source = "material_name")
    @Mapping(target = "material_quantity.quantity", source = "material_quantity")
    Building toEntity(BuildingCreateDto buildingCreateDto);

    @AfterMapping
    default void createdOwnerInfo(@MappingTarget Building building, BuildingCreateDto buildingCreateDto){
        Owner owner = new Owner();
        owner.setFirstName(buildingCreateDto.getFirstName());
        owner.setLastName(buildingCreateDto.getLastName());
        owner.setTellNumber(buildingCreateDto.getTellNumber());
        building.setOwner(owner);
        Material_quantity materialQuantity = new Material_quantity();
        materialQuantity.setQuantity(buildingCreateDto.getMaterial_quantity());
        materialQuantity.setBuilding(building);
//        materialQuantity.setMaterial();
    }

    @Mapping(target ="buildingId", source = "id")
    BuildingAfterCreationDto toDto(Building buildingAfterCreation);
}

