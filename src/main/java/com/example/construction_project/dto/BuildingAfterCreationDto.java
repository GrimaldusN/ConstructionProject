package com.example.construction_project.dto;

import lombok.Data;

@Data
public class BuildingAfterCreationDto {
    private String buildingId;
    private String status = "Building is Created";
}
