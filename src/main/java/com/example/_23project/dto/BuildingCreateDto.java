package com.example._23project.dto;

import com.example._23project.entity.Address;
import com.example._23project.entity.Owner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Value;

@Value
public class BuildingCreateDto {
    double cost;

    String address;

    String owner;
}
