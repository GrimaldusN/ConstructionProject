package com.example.construction_project.mapper;

import com.example.construction_project.dto.UserAfterCreationDto;
import com.example.construction_project.dto.UserCreateDto;
import com.example.construction_project.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "login", source = "login")
    @Mapping(target = "password", source = "password")
    User toEntity(UserCreateDto userCreateDto);
    @Mapping(target = "userId",source = "id")
    UserAfterCreationDto toDto(User userAfterCreation);
}
