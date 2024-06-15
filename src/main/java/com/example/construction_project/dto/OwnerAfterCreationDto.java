package com.example.construction_project.dto;

import lombok.Data;

@Data
public class OwnerAfterCreationDto {
    private String ownerId;
    private String status = "Owner is Created";
}
