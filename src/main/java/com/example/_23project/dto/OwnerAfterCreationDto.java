package com.example._23project.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class OwnerAfterCreationDto {
    String ownerId;
    String status = "Owner is Created";
}
