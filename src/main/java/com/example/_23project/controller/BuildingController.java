package com.example._23project.controller;

import com.example._23project.entity.Building;
import com.example._23project.sevice.BuildingService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/building")
public class BuildingController {
    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingsService) {
        this.buildingService = buildingsService;
    }

    @GetMapping("/get/{id}")
    public Building getBuildingById(@PathVariable("id") String id){
        return buildingService.getBuildingById(id);
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteBuildingById(@PathVariable("id") String id){
        return buildingService.deleteBuildingById(id);
    }
}