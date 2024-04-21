package com.example._23project.dto.Address;

import lombok.Data;

@Data
public class AddressAfterCreationDto {
    String addressId;
    String status = "Address is Created";
}
