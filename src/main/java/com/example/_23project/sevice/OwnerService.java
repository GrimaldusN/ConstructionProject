package com.example._23project.sevice;

import com.example._23project.dto.Owner.OwnerAfterCreationDto;
import com.example._23project.dto.Owner.OwnerCreateDto;
import com.example._23project.entity.Owner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public interface OwnerService {
    Owner getOwnerById(String id);

    Owner findByTellNumber(int tellNumber);

    void deleteOwnerById(String id);

    Owner updateOwnerByTellNumber(int tellNumer, int newTellNumer);
    OwnerAfterCreationDto createOwner(OwnerCreateDto ownerCreateDto);
}
