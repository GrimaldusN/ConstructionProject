package com.example.construction_project.service;

import com.example.construction_project.dto.OwnerAfterCreationDto;
import com.example.construction_project.dto.OwnerCreateDto;
import com.example.construction_project.entity.Owner;

import java.util.List;
import java.util.UUID;

public interface OwnerService {
    List<Owner> getAll();

    Owner getOwnerById(UUID id);

    void deleteOwnerById(UUID id);

    Owner updateOwnerByTellNumber(String tellNumer, String newTellNumer);
    OwnerAfterCreationDto createOwner(OwnerCreateDto ownerCreateDto);
}
