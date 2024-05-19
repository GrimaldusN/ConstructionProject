package com.example._23project.service.impl;

import com.example._23project.dto.BuildingAfterCreationDto;
import com.example._23project.dto.BuildingCreateDto;
import com.example._23project.entity.Building;
import com.example._23project.exception.BuildingAlreadyExistException;
import com.example._23project.exception.BuildingNotExistException;
import com.example._23project.exception.ErrorMessage;
import com.example._23project.mapper.BuildingMapper;
import com.example._23project.repository.BuildingRepository;
import com.example._23project.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {
    private final BuildingRepository buildingRepository;
    private final BuildingMapper buildingMapper;

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