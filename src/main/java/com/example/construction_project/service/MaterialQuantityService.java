package com.example.construction_project.service;

import com.example.construction_project.dto.MaterialQuantityAfterCreationDto;
import com.example.construction_project.dto.MaterialQuantityCreateDto;
import com.example.construction_project.entity.Material_quantity;

import java.util.List;
import java.util.UUID;

public interface MaterialQuantityService {
    List<Material_quantity> getAll();

    Material_quantity getMaterialById(UUID id);

    void  deleteMaterialById(UUID id);

    MaterialQuantityAfterCreationDto createMaterialQuantity(MaterialQuantityCreateDto materialQuantityCreateDto);
}
