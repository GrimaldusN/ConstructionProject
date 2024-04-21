package com.example._23project.sevice;

import com.example._23project.dto.Address.AddressAfterCreationDto;
import com.example._23project.dto.Address.AddressCreateDto;
import com.example._23project.entity.Address;

public interface AddressService {
    Address getAddressById(String id);
    Address findAddressByStreet(String addressName);
    String updateAddressByStreet(String street, String newStreet);

    void deleteAddressById(String id);
    AddressAfterCreationDto createAddress(AddressCreateDto addressCreateDto);
}
