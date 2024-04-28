package com.example._23project.sevice;

import com.example._23project.dto.OwnerAfterCreationDto;
import com.example._23project.dto.OwnerCreateDto;
import com.example._23project.entity.Owner;

public interface OwnerService {
    Owner getOwnerById(String id);

    void deleteOwnerById(String id);

    Owner updateOwnerByTellNumber(int tellNumer, int newTellNumer);
    OwnerAfterCreationDto createOwner(OwnerCreateDto ownerCreateDto);
}
