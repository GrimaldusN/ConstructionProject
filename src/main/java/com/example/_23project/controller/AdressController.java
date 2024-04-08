package com.example._23project.controller;

import com.example._23project.entity.Adress;
import com.example._23project.sevice.AdressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/adress")
public class AdressController {
    private final AdressService adressService;

    public AdressController(AdressService adressService) {
        this.adressService = adressService;
    }

    @GetMapping("/get/{id}")
    public Adress getAdressById(@PathVariable("id") UUID id){
        return adressService.getAdressById(id);
    }
}
