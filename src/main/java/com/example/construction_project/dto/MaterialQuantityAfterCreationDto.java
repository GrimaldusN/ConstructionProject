package com.example.construction_project.dto;

import lombok.Data;

@Data
public class MaterialQuantityAfterCreationDto {
    private String materialQuantityId;
    private String status = "Material_quantity is created";
}
