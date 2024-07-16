package com.example.construction_project.service.impl;

import com.example.construction_project.dto.OwnerAfterCreationDto;
import com.example.construction_project.dto.OwnerCreateDto;
import com.example.construction_project.entity.Owner;
import com.example.construction_project.exception.*;
import com.example.construction_project.mapper.OwnerMapper;
import com.example.construction_project.repository.OwnerRepository;
import com.example.construction_project.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    @Override
    public List<Owner> getAll() {
        List<Owner> owners = ownerRepository.findAll();
        if (owners == null){
            throw new OwnersEmpty(ErrorMessage.OWNERS_EMPTY);
        }return owners;
    }

    @Override
    public Owner getOwnerById(UUID id) {
        Owner owner = ownerRepository.getOwnerById(id);
        if (owner == null){
            throw new OwnerNotExistException(ErrorMessage.OWNER_NOT_EXIST);
        }
        return owner;
    }

    @Override
    public void deleteOwnerById(UUID id) {
        if (ownerRepository.getOwnerById(id) == null){
            throw new OwnerNotExistException(ErrorMessage.OWNER_NOT_EXIST);
        } ownerRepository.deleteOwnerById(id);
        System.out.println("Owner removed");
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Owner updateOwnerByTellNumber(String tellNumer, String newTellNumer) {
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
