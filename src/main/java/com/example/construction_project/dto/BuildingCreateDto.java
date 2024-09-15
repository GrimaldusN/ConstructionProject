package com.example.construction_project.dto;

import lombok.Data;
import lombok.Value;

@Data
public class BuildingCreateDto {
    String name;
    double cost;
    String address;
    String firstName;
    String lastName;
    String tellNumber;
    String material_name;
    int material_quantity;
}
