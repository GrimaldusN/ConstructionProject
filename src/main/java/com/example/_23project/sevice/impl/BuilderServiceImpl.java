package com.example._23project.sevice.impl;

import com.example._23project.dto.Builder.BuilderAfterCreationDto;
import com.example._23project.dto.Builder.BuilderCreateDto;
import com.example._23project.entity.Builder;
import com.example._23project.exception.*;
import com.example._23project.mapper.BuilderMapper;
import com.example._23project.repository.BuilderRepository;
import com.example._23project.sevice.BuilderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class BuilderServiceImpl implements BuilderService {
    private final BuilderRepository builderRepository;
    private final BuilderMapper builderMapper;
    @Override
    public Builder getBuilderById(String id) {
        Builder builder = builderRepository.getBuilderById(UUID.fromString(id));
        if (builder == null){
            throw new BuilderNotExistException(ErrorMessage.BUILDER_NOT_EXIST);
        }
        return builder;
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Builder findByTellNumber(int tellNumber) {
        Builder builder = builderRepository.findByTellNumber(tellNumber);
        if (builder == null){
            throw new BuilderNotExistException(ErrorMessage.BUILDER_NOT_EXIST);
        }return builder;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteBuilderById(String id) {
        if (builderRepository.getBuilderById(UUID.fromString(id)) == null){
            throw new BuilderNotExistException(ErrorMessage.BUILDER_NOT_EXIST);
        } builderRepository.deleteBuilderById(UUID.fromString(id));
        System.out.println("Address removed");
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public String updateBuilderByTellNumber(int tellNumer, int newTellNumer) {
        Builder builder = builderRepository.findByTellNumber(tellNumer);
        if (builder == null){
            throw new BuilderNotExistException(ErrorMessage.BUILDER_NOT_EXIST);
        }else {
            if (Objects.equals(builder.getTellNumber(), newTellNumer)){
                throw new BuilderAlreadyExistException(ErrorMessage.BUILDER_ALREADY_EXIST);
            }else {
                builder.setTellNumber(newTellNumer);
                builderRepository.saveAndFlush(builder);
            }
        }return "Builder is corrected";
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public BuilderAfterCreationDto createBuilder(BuilderCreateDto builderCreateDto) {
        List<Builder> builders = builderRepository.findByBuilderDescription(builderCreateDto.getLastName());
        if (builders != null){
            throw new BuilderAlreadyExistException(ErrorMessage.BUILDER_ALREADY_EXIST);
        }
        Builder entity = builderMapper.toEntity(builderCreateDto);
        Builder builderAfterCreation = builderRepository.save(entity);
        return builderMapper.toDto(builderAfterCreation);
    }
}
