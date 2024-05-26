package com.example._23project.controller;

import com.example._23project.dto.OwnerAfterCreationDto;
import com.example._23project.dto.OwnerCreateDto;
import com.example._23project.entity.Owner;
import com.example._23project.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/get/{id}")
    public Owner getOwnerById(@PathVariable("id") UUID id){
        return ownerService.getOwnerById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOwnerById(@PathVariable("id") UUID id){
        ownerService.deleteOwnerById(id);
    }

    @PutMapping("/owners/updateByTellNumber")
    public Owner updateOwnerByTellNumber(
            @RequestParam("tellNumber") int tellNumber,
            @RequestParam("newTellNumber") int newTellNumber) {
        return ownerService.updateOwnerByTellNumber(tellNumber, newTellNumber);
    }

    @PostMapping("/create")
    public OwnerAfterCreationDto createOwner(@RequestBody OwnerCreateDto ownerCreateDto){
        return ownerService.createOwner(ownerCreateDto);
    }
}
