package com.example.construction_project.controller;

import com.example.construction_project.dto.BuildingAfterCreationDto;
import com.example.construction_project.dto.BuildingCreateDto;
import com.example.construction_project.entity.Building;
import com.example.construction_project.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/building")
public class BuildingController {
    private final BuildingService buildingService;
    @GetMapping
    public List<Building> getBuildings(){
        return new ArrayList<>(buildingService.getAll());
    }

    @GetMapping("/{id}")
    public Building getBuildingById(@PathVariable("id") UUID id){
        return buildingService.getBuildingById(id);
    }

    @DeleteMapping ("/{id}")
    public void deleteBuildingById(@PathVariable("id") UUID id){
        buildingService.deleteBuildingById(id);
    }

    @PostMapping()
    public BuildingAfterCreationDto createBuilding(@RequestBody BuildingCreateDto buildingCreateDto){
        return buildingService.createBuilding(buildingCreateDto);
    }
}