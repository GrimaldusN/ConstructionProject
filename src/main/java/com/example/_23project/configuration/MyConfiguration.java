package com.example._23project.configuration;

import com.example._23project.mapper.BuildingMapper;
import com.example._23project.mapper.OwnerMapper;
import com.example._23project.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public BuildingMapper buildingMapper() {
        return Mappers.getMapper(BuildingMapper.class);
    }

    @Bean
    public OwnerMapper ownerMapper() {
        return Mappers.getMapper(OwnerMapper.class);
    }

    @Bean
    public UserMapper userMapper() {
        return Mappers.getMapper(UserMapper.class);
    }
}

