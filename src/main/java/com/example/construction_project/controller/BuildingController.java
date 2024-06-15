package com.example.construction_project.controller;

import com.example.construction_project.dto.BuildingAfterCreationDto;
import com.example.construction_project.dto.BuildingCreateDto;
import com.example.construction_project.entity.Building;
import com.example.construction_project.service.BuildingService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/building")
public class BuildingController {
    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingsService) {
        this.buildingService = buildingsService;
    }

    @GetMapping("/get/{id}")
    public Building getBuildingById(@PathVariable("id") UUID id){
        return buildingService.getBuildingById(id);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteBuildingById(@PathVariable("id") UUID id){
        buildingService.deleteBuildingById(id);
    }

    @PostMapping("/create")
    public BuildingAfterCreationDto createBuilding(@RequestBody BuildingCreateDto buildingCreateDto){
        return buildingService.createBuilding(buildingCreateDto);
    }
}