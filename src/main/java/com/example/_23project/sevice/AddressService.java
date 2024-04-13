package com.example._23project.sevice;

import com.example._23project.entity.Address;

import java.util.UUID;

public interface AddressService {
    Address getAddressById(String id);

    String deleteAddressById(String id);
}
