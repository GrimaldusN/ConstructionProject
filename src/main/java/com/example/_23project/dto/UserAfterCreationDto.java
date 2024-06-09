package com.example._23project.dto;

import lombok.Data;

@Data
public class UserAfterCreationDto {
    String userId;
    String status= "User is Created";

    public void setId(String string) {
    }
}
