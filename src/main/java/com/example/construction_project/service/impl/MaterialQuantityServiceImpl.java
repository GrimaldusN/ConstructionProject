package com.example.construction_project.service.impl;

import com.example.construction_project.dto.MaterialQuantityAfterCreationDto;
import com.example.construction_project.dto.MaterialQuantityCreateDto;
import com.example.construction_project.entity.Material_quantity;
import com.example.construction_project.exception.ErrorMessage;
import com.example.construction_project.exception.MaterialNotExistExcepction;
import com.example.construction_project.mapper.MaterialQuantityMapper;
import com.example.construction_project.repository.MaterialQuantityRepository;
import com.example.construction_project.service.MaterialQuantityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MaterialQuantityServiceImpl implements MaterialQuantityService {
    private final MaterialQuantityRepository materialQuantityRepository;
    private final MaterialQuantityMapper materialQuantityMapper;

    @Override
    public List<Material_quantity> getAll() {
        List<Material_quantity> materials = materialQuantityRepository.findAll();
        if (materials.isEmpty()){
            throw new MaterialNotExistExcepction(ErrorMessage.MATERIAL_NOT_EXIST);
        }return materials;
    }

    @Override
    public Material_quantity getMaterialById(UUID id) {
        Material_quantity material = materialQuantityRepository.getMaterialById(id);
        if (material == null){
            throw new MaterialNotExistExcepction(ErrorMessage.MATERIAL_NOT_EXIST);
        }return material;
    }

    @Override
    public void deleteMaterialById(UUID id) {
        if (materialQuantityRepository.findById(id).isEmpty()){
            throw new MaterialNotExistExcepction(ErrorMessage.MATERIAL_NOT_EXIST);
        }materialQuantityRepository.deleteMaterialById(id);
        System.out.println("Material by id: " + id + " is deleted" );
    }

    @Override
    public MaterialQuantityAfterCreationDto createMaterialQuantity(MaterialQuantityCreateDto materialQuantityCreateDto) {
        Material_quantity entity = materialQuantityMapper.toEntity(materialQuantityCreateDto);
        Material_quantity materialQuantityAfterCreation = materialQuantityRepository.save(entity);
        return materialQuantityMapper.toDto(materialQuantityAfterCreation);
    }
}
