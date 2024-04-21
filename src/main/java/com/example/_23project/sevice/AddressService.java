package com.example._23project.sevice;

import com.example._23project.dto.AddressAfterCreationDto;
import com.example._23project.dto.AddressCreateDto;
import com.example._23project.dto.BuildingAfterCreationDto;
import com.example._23project.dto.BuildingCreateDto;
import com.example._23project.entity.Address;

import java.util.UUID;

public interface AddressService {
    Address getAddressById(String id);
    Address findAddressByStreet(String addressName);
    String updateAddressByStreet(String street, String newStreet);

    void deleteAddressById(String id);
    AddressAfterCreationDto createAddress(AddressCreateDto addressCreateDto);
}
