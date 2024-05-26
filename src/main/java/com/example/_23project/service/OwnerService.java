package com.example._23project.service;

import com.example._23project.dto.OwnerAfterCreationDto;
import com.example._23project.dto.OwnerCreateDto;
import com.example._23project.entity.Owner;

import java.util.UUID;

public interface OwnerService {
    Owner getOwnerById(UUID id);

    void deleteOwnerById(UUID id);

    Owner updateOwnerByTellNumber(int tellNumer, int newTellNumer);
    OwnerAfterCreationDto createOwner(OwnerCreateDto ownerCreateDto);
}
