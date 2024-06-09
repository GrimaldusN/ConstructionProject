package com.example._23project.mapper;

import com.example._23project.dto.UserAfterCreationDto;
import com.example._23project.dto.UserCreateDto;
import com.example._23project.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "login", source = "login")
    User toEntity(UserCreateDto userCreateDto);
    @Mapping(target = "userId",source = "id")
    UserAfterCreationDto toDto(User userAfterCreation);
}
