package com.example.construction_project.controller;

import com.example.construction_project.dto.MaterialQuantityAfterCreationDto;
import com.example.construction_project.dto.MaterialQuantityCreateDto;
import com.example.construction_project.entity.Material_quantity;
import com.example.construction_project.service.MaterialQuantityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/material_quantity")
public class MaterialQuantityController {
    private final MaterialQuantityService materialQuantityService;

    @GetMapping
    public List<Material_quantity> getMaterials() {
        return new ArrayList<>(materialQuantityService.getAll());
    }

    @GetMapping("/{id}")
    public Material_quantity getMaterialById(@PathVariable("id")UUID id) {
        return materialQuantityService.getMaterialById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterialById(@PathVariable("id")UUID id) {
        materialQuantityService.deleteMaterialById(id);
    }

    @PostMapping()
    public MaterialQuantityAfterCreationDto createMaterialQuantity(@RequestBody MaterialQuantityCreateDto materialQuantityCreateDto){
        return materialQuantityService.createMaterialQuantity(materialQuantityCreateDto);
    }
}
