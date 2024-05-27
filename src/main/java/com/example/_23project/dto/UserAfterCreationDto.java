package com.example._23project.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserAfterCreationDto {
    String userId;
    String status= "User is Created";

    public Object getId() {
        return userId;
    }

    public void setId(Object id) {
        this.userId = userId;
    }
}
