package com.example._23project.sevice;

import com.example._23project.dto.AddressAfterCreationDto;
import com.example._23project.dto.AddressCreateDto;
import com.example._23project.dto.BuildingAfterCreationDto;
import com.example._23project.dto.BuildingCreateDto;
import com.example._23project.entity.Address;

import java.util.UUID;

public interface AddressService {
    Address getAddressById(String id);

    void deleteAddressById(String id);
    AddressAfterCreationDto createAddress(AddressCreateDto addressCreateDto);
}
