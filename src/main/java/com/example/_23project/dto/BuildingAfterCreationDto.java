package com.example._23project.dto;

import lombok.Data;

@Data
public class BuildingAfterCreationDto {
    private String buildingId;
    private String status = "Building is Created";
}
