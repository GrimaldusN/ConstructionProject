package com.example._23project.sevice.impl;

import com.example._23project.entity.Address;
import com.example._23project.exception.AddressNotExistException;
import com.example._23project.exception.ErrorMessage;
import com.example._23project.repository.AddressRepository;
import com.example._23project.sevice.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Address getAddressById(String id) {
        Address address = addressRepository.getAddressById(UUID.fromString(id));
        if (address == null){
            throw new AddressNotExistException(ErrorMessage.ADDRESS_NOT_EXIST);
        }
        return address;
    }

    @Override
    public String removeAddressById(String id) {
        Address address = addressRepository.getAddressById(UUID.fromString(id));
        if (address == null){
            throw new AddressNotExistException(ErrorMessage.ADDRESS_NOT_EXIST);
        } address = null;
        return "Address removed";
    }

}
