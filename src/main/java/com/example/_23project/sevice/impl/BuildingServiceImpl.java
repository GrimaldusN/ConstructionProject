package com.example._23project.sevice.impl;

import com.example._23project.entity.Address;
import com.example._23project.entity.Building;
import com.example._23project.exception.AddressNotExistException;
import com.example._23project.exception.BuildingNotExistException;
import com.example._23project.exception.ErrorMessage;
import com.example._23project.repository.AddressRepository;
import com.example._23project.repository.BuildingRepository;
import com.example._23project.sevice.AddressService;
import com.example._23project.sevice.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {
    private final BuildingRepository buildingRepository;

    @Override
    public Building getBuildingById(String id) {
        Building building = buildingRepository.getBuildingById(UUID.fromString(id));
        if (building == null){
            throw new BuildingNotExistException(ErrorMessage.BUILDING_NOT_EXIST);
        }
        return building;
    }

    @Override
    public String removeBuildingById(String id) {
        Building building = buildingRepository.getBuildingById(UUID.fromString(id));
        if (building == null){
            throw new BuildingNotExistException(ErrorMessage.BUILDING_NOT_EXIST);
        } building = null;
        return "Building removed";
    }

}