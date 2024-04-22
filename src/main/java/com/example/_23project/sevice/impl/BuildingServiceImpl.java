package com.example._23project.sevice.impl;

import com.example._23project.dto.Building.BuildingAfterCreationDto;
import com.example._23project.dto.Building.BuildingCreateDto;
import com.example._23project.entity.Address;
import com.example._23project.entity.Building;
import com.example._23project.exception.BuildingAlreadyExistException;
import com.example._23project.exception.BuildingNotExistException;
import com.example._23project.exception.ErrorMessage;
import com.example._23project.mapper.BuildingMapper;
import com.example._23project.repository.AddressRepository;
import com.example._23project.repository.BuildingRepository;
import com.example._23project.sevice.BuildingService;
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
    private final AddressRepository addressRepository;

    @Override
    public Building getBuildingById(String id) {
        Building building = buildingRepository.getBuildingById(UUID.fromString(id));
        if (building == null){
            throw new BuildingNotExistException(ErrorMessage.BUILDING_NOT_EXIST);
        }
        return building;
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Building getBuildingByAddressName(String addressName) {
        Building building = buildingRepository.getBuildingByAddressName(addressName);
        if (building == null){
            throw new BuildingNotExistException(ErrorMessage.BUILDING_NOT_EXIST);
        }
        return building;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteBuildingById(String id) {
        if (buildingRepository.findById(UUID.fromString(id)).isEmpty()){
            throw new BuildingNotExistException(ErrorMessage.BUILDING_NOT_EXIST);
        }
        buildingRepository.deleteBuildingById(UUID.fromString(id));
        System.out.println("Building is deleted");
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public BuildingAfterCreationDto createBuilding(BuildingCreateDto buildingCreateDto) {
        List<Building> building = buildingRepository.findByBuildingDescription(buildingCreateDto.getAddressName());
        if (building != null){
            throw new BuildingAlreadyExistException(ErrorMessage.BUILDING_ALREADY_EXIST);
        }

        String addressName = buildingCreateDto.getAddressName();
        Address address = addressRepository.findAddressByStreet(addressName);
        Building entity = buildingMapper.toEntity(buildingCreateDto);
        entity.setAddress(address);
        Building buildingAfterCreation = buildingRepository.save(entity);
        return buildingMapper.toDto(buildingAfterCreation);
    }


}