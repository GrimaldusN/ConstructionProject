package com.example._23project.dto;

import lombok.Data;

@Data
public class UserAfterCreationDto {
    private String userId;
    private String status= "User is Created";

    public void setId(String string) {
    }
}
