package com.example._23project.controller;

import com.example._23project.entity.Address;
import com.example._23project.sevice.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService adressService;

    public AddressController(AddressService adressService) {
        this.adressService = adressService;
    }

    @GetMapping("/get/{id}")
    public Address getAddressById(@PathVariable("id") String id){
        return adressService.getAddressById(id);
    }
}
