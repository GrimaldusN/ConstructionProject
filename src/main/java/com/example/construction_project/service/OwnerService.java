package com.example.construction_project.service;

import com.example.construction_project.dto.OwnerAfterCreationDto;
import com.example.construction_project.dto.OwnerCreateDto;
import com.example.construction_project.entity.Owner;

import java.util.UUID;

public interface OwnerService {
    Owner getOwnerById(UUID id);

    void deleteOwnerById(UUID id);

    Owner updateOwnerByTellNumber(int tellNumer, int newTellNumer);
    OwnerAfterCreationDto createOwner(OwnerCreateDto ownerCreateDto);
}
