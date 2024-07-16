package com.example.construction_project.service.impl;

import com.example.construction_project.dto.BuildingAfterCreationDto;
import com.example.construction_project.dto.BuildingCreateDto;
import com.example.construction_project.entity.Building;
import com.example.construction_project.exception.BuildingAlreadyExistException;
import com.example.construction_project.exception.BuildingNotExistException;
import com.example.construction_project.exception.BuildingsEmpty;
import com.example.construction_project.exception.ErrorMessage;
import com.example.construction_project.mapper.BuildingMapper;
import com.example.construction_project.repository.BuildingRepository;
import com.example.construction_project.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {
    private final BuildingRepository buildingRepository;
    private final BuildingMapper buildingMapper;


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
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteBuildingById(UUID id) {
        if (buildingRepository.findById(id).isEmpty()){
            throw new BuildingNotExistException(ErrorMessage.BUILDING_NOT_EXIST);
        }
        buildingRepository.deleteBuildingById(id);
        System.out.println("Building is deleted");
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public BuildingAfterCreationDto createBuilding(BuildingCreateDto buildingCreateDto) {
        Building building = buildingRepository.getBuildingByName(buildingCreateDto.getName());
        if (building != null){
            throw new BuildingAlreadyExistException(ErrorMessage.BUILDING_ALREADY_EXIST);
        }
        Building entity = buildingMapper.toEntity(buildingCreateDto);
        Building buildingAfterCreation = buildingRepository.save(entity);
        return buildingMapper.toDto(buildingAfterCreation);
    }
}