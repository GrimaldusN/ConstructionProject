package com.example.construction_project.dto;

import lombok.Value;

@Value
public class MaterialQuantityCreateDto {
    String buildingName;
    String address;
    String firstName;
    String lastName;
    String tellNumber;
    String materialName;
    double materialCost;
    int quantity;
}
