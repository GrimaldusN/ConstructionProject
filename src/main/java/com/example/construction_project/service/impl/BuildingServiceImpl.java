package com.example.construction_project.service.impl;

import com.example.construction_project.dto.BuildingAfterCreationDto;
import com.example.construction_project.dto.BuildingCreateDto;
import com.example.construction_project.entity.Building;
import com.example.construction_project.entity.Material;
import com.example.construction_project.entity.Material_quantity;
import com.example.construction_project.entity.Owner;
import com.example.construction_project.exception.BuildingNotExistException;
import com.example.construction_project.exception.BuildingsEmpty;
import com.example.construction_project.exception.ErrorMessage;
import com.example.construction_project.mapper.BuildingMapper;
import com.example.construction_project.repository.BuildingRepository;
import com.example.construction_project.repository.MaterialQuantityRepository;
import com.example.construction_project.repository.MaterialRepository;
import com.example.construction_project.repository.OwnerRepository;
import com.example.construction_project.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {
    private final BuildingRepository buildingRepository;
    private final BuildingMapper buildingMapper;
    private final MaterialQuantityRepository materialQuantityRepository;
    private final MaterialRepository materialRepository;
    private final OwnerRepository ownerRepository;


    @Override
    public List<Building> getAll() {
        List<Building> buildings = buildingRepository.findAll();
        if (buildings == null){
            throw new BuildingsEmpty(ErrorMessage.BUILDINGS_EMPTY);
        }return buildings;
    }

    @Override
    public Building getBuildingById(UUID id) {
        Building building = buildingRepository.getBuildingById(id);
        if (building == null){
            throw new BuildingNotExistException(ErrorMessage.BUILDING_NOT_EXIST);
        }
        return building;
    }

    @Override
    public void deleteBuildingById(UUID id) {
        if (buildingRepository.findById(id).isEmpty()){
            throw new BuildingNotExistException(ErrorMessage.BUILDING_NOT_EXIST);
        }
        buildingRepository.deleteBuildingById(id);
        System.out.println("Building is deleted");
    }

    @Override
    @Transactional
    public BuildingAfterCreationDto createBuilding(BuildingCreateDto buildingCreateDto) {
        Owner owner = new Owner();
        owner.setFirstName(buildingCreateDto.getFirstName());
        owner.setLastName(buildingCreateDto.getLastName());
        owner.setTellNumber(buildingCreateDto.getTellNumber());
        ownerRepository.save(owner);

        Material material = materialRepository.findMaterialByName(buildingCreateDto.getMaterial_name());
        if (material == null) {
            material = new Material();
            material.setName(buildingCreateDto.getMaterial_name());
            material.setCost(buildingCreateDto.getCost());
            materialRepository.save(material);
        }

        Building building = buildingMapper.toEntity(buildingCreateDto);
        building.setOwner(owner);

        Building savedBuilding = buildingRepository.save(building);

        Material_quantity materialQuantity = new Material_quantity();
        materialQuantity.setMaterial(material);
        materialQuantity.setQuantity(buildingCreateDto.getMaterial_quantity());
        materialQuantity.setBuilding(savedBuilding);

        materialQuantityRepository.save(materialQuantity);

        savedBuilding.setMaterial_quantity(materialQuantity);

        buildingRepository.save(savedBuilding);
        return buildingMapper.toDto(savedBuilding);
    }
}