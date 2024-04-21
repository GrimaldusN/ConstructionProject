package com.example._23project.dto.Building;

import lombok.Data;

@Data
public class BuildingAfterCreationDto {
    String buildingId;
    String address;
    String status = "Building is Created";
}
