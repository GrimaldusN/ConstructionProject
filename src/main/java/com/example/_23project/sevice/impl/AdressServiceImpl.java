package com.example._23project.sevice.impl;

import com.example._23project.entity.Adress;
import com.example._23project.repository.AdressRepository;
import com.example._23project.sevice.AdressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdressServiceImpl implements AdressService {
    private final AdressRepository adressRepository;

    @Override
    public Adress getAdressById(UUID id) {
        return adressRepository.getById(id);
    }
}
