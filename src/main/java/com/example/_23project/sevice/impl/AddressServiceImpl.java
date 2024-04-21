package com.example._23project.sevice.impl;

import com.example._23project.dto.AddressAfterCreationDto;
import com.example._23project.dto.AddressCreateDto;
import com.example._23project.entity.Address;
import com.example._23project.exception.AddressAlreadyExistException;
import com.example._23project.exception.AddressNotExistException;
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
    public Address findAddressByStreet(String addressName) {
        Address address = addressRepository.findAddressByStreet(addressName);
        if (address != null){
            throw new AddressAlreadyExistException(ErrorMessage.ADDRESS_ALREADY_EXIST);
        }
        return address;
    }

    @Override
    public String updateAddressByStreet(String street, String newStreet) {
        Address address = addressRepository.findAddressByStreet(street);
        if(address == null) {
            throw new AddressNotExistException(ErrorMessage.ADDRESS_NOT_EXIST);
        } else {
            if(address.getStreet().equals(newStreet)) {
                throw new AddressAlreadyExistException(ErrorMessage.ADDRESS_ALREADY_EXIST);
            } else {
                address.setStreet(newStreet);
                addressRepository.saveAndFlush(address);
            }
        }return "Address are corrected";
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
