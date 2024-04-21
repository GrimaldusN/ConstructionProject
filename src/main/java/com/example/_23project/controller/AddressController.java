package com.example._23project.controller;

import com.example._23project.dto.Address.AddressAfterCreationDto;
import com.example._23project.dto.Address.AddressCreateDto;
import com.example._23project.entity.Address;
import com.example._23project.sevice.AddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/get/{id}")
    public Address getAddressById(@PathVariable("id") String id){
        return addressService.getAddressById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddressById(@PathVariable("id") String id){
        addressService.deleteAddressById(id);
    }

    @PostMapping("/create")
    public AddressAfterCreationDto createAddress(@RequestBody AddressCreateDto addressCreateDto){
        return addressService.createAddress(addressCreateDto);
    }
}
