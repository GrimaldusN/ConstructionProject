package com.example._23project.dto;

import lombok.Data;

@Data
public class OwnerAfterCreationDto {
    private String ownerId;
    private String status = "Owner is Created";
}
