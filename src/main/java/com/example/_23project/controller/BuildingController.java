package com.example._23project.controller;

import com.example._23project.entity.Building;
import com.example._23project.sevice.BuildingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/remove/{id}")
    public String removeBuildingById(@PathVariable("id") String id){
        return buildingService.removeBuildingById(id);
    }
}