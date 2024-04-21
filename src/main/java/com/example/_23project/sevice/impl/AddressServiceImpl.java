package com.example._23project.sevice.impl;

import com.example._23project.dto.AddressAfterCreationDto;
import com.example._23project.dto.AddressCreateDto;
import com.example._23project.entity.Address;
import com.example._23project.entity.Building;
import com.example._23project.exception.AddressAlreadyExistException;
import com.example._23project.exception.AddressNotExistException;
import com.example._23project.exception.BuildingNotExistException;
import com.example._23project.exception.ErrorMessage;
import com.example._23project.mapper.AddressMapper;
import com.example._23project.repository.AddressRepository;
import com.example._23project.sevice.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public Address getAddressById(String id) {
        Address address = addressRepository.getAddressById(UUID.fromString(id));
        if (address == null){
            throw new AddressNotExistException(ErrorMessage.ADDRESS_NOT_EXIST);
        }
        return address;
    }

    @Override
    public Address getAddressByName(String addressName) {
        Address address = addressRepository.getAddressByName(addressName);
        if (address != null){
            throw new AddressAlreadyExistException(ErrorMessage.ADDRESS_ALREADY_EXIST);
        }
        return address;
    }

    @Override
    public void deleteAddressById(String id) {
        if (addressRepository.getAddressById(UUID.fromString(id)) == null){
            throw new AddressNotExistException(ErrorMessage.ADDRESS_NOT_EXIST);
        } addressRepository.deleteAddressById(UUID.fromString(id));
        System.out.println("Address removed");
    }

    @Override
    public AddressAfterCreationDto createAddress(AddressCreateDto addressCreateDto) {
        List<Address> address = addressRepository.findByAddressDescription(addressCreateDto.getStreet());
        if (address != null){
            throw new AddressAlreadyExistException(ErrorMessage.ADDRESS_ALREADY_EXIST);
        }
        Address entity = addressMapper.toEntity(addressCreateDto);
        Address buildingAfterCreation = addressRepository.save(entity);
        return addressMapper.toDto(buildingAfterCreation);
    }

}
