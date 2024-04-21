package com.example._23project.controller;

import com.example._23project.dto.Address.AddressAfterCreationDto;
import com.example._23project.dto.Address.AddressCreateDto;
import com.example._23project.dto.Builder.BuilderAfterCreationDto;
import com.example._23project.dto.Builder.BuilderCreateDto;
import com.example._23project.entity.Address;
import com.example._23project.entity.Builder;
import com.example._23project.sevice.AddressService;
import com.example._23project.sevice.BuilderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/builder")
public class BuilderController {
    private final BuilderService builderService;

    public BuilderController(BuilderService builderService) {
        this.builderService = builderService;
    }

    @GetMapping("/get/{id}")
    public Builder getBuilderById(@PathVariable("id") String id){
        return builderService.getBuilderById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBuilderById(@PathVariable("id") String id){
        builderService.deleteBuilderById(id);
    }

    @PostMapping("/create")
    public BuilderAfterCreationDto createBuilder(@RequestBody BuilderCreateDto builderCreateDto){
        return builderService.createBuilder(builderCreateDto);
    }
}
