package com.example._23project.dto;

import lombok.Getter;
import lombok.Value;

@Value
public class AddressCreateDto {
    @Getter
    String street;
    double number;

}
