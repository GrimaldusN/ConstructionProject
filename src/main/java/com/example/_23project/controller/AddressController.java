package com.example._23project.controller;

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
    public String deleteAddressById(@PathVariable("id") String id){
        return addressService.deleteAddressById(id);
    }
}