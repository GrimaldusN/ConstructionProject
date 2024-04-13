package com.example._23project.controller;

import com.example._23project.entity.Address;
import com.example._23project.sevice.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/remove/{id}")
    public String removeAddressById(@PathVariable("id") String id){
        return addressService.removeAddressById(id);
    }
}
