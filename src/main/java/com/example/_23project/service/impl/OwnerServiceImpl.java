package com.example._23project.service.impl;

import com.example._23project.dto.OwnerAfterCreationDto;
import com.example._23project.dto.OwnerCreateDto;
import com.example._23project.entity.Owner;
import com.example._23project.exception.*;
import com.example._23project.mapper.OwnerMapper;
import com.example._23project.repository.OwnerRepository;
import com.example._23project.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    @Override
    public Owner getOwnerById(String id) {
        Owner owner = ownerRepository.getOwnerById(UUID.fromString(id));
        if (owner == null){
            throw new OwnerNotExistException(ErrorMessage.OWNER_NOT_EXIST);
        }
        return owner;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteOwnerById(String id) {
        if (ownerRepository.getOwnerById(UUID.fromString(id)) == null){
            throw new OwnerNotExistException(ErrorMessage.OWNER_NOT_EXIST);
        } ownerRepository.deleteOwnerById(UUID.fromString(id));
        System.out.println("Owner removed");
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Owner updateOwnerByTellNumber(int tellNumer, int newTellNumer) {
        Owner owner = ownerRepository.findByTellNumber(tellNumer);
        if (owner == null){
            throw new OwnerNotExistException(ErrorMessage.OWNER_NOT_EXIST);
        }else {
            if (Objects.equals(owner.getTellNumber(), newTellNumer)){
                throw new OwnerAlreadyExistException(ErrorMessage.OWNER_ALREADY_EXIST);
            }else {
                owner.setTellNumber(newTellNumer);
                ownerRepository.saveAndFlush(owner);
            }
        }return owner;
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public OwnerAfterCreationDto createOwner(OwnerCreateDto ownerCreateDto) {
        Owner owners = ownerRepository.findByTellNumber(ownerCreateDto.getTellNumber());
        if (owners != null){
            throw new OwnerAlreadyExistException(ErrorMessage.OWNER_ALREADY_EXIST);
        }
        Owner entity = ownerMapper.toEntity(ownerCreateDto);
        Owner ownerAfterCreation = ownerRepository.save(entity);
        return ownerMapper.toDto(ownerAfterCreation);
    }

}
