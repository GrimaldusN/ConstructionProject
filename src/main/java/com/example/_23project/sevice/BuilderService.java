package com.example._23project.sevice;

import com.example._23project.dto.Address.AddressAfterCreationDto;
import com.example._23project.dto.Address.AddressCreateDto;
import com.example._23project.dto.Builder.BuilderAfterCreationDto;
import com.example._23project.dto.Builder.BuilderCreateDto;
import com.example._23project.entity.Builder;

public interface BuilderService {
    Builder getBuilderById(String id);
    Builder findByTellNumber(int tellNumber);
    void deleteBuilderById(String id);
    String updateBuilderByTellNumber(int tellNumer, int newTellNumer);
    BuilderAfterCreationDto createBuilder(BuilderCreateDto builderCreateDto);
}
