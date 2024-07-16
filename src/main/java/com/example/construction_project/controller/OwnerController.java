package com.example.construction_project.controller;

import com.example.construction_project.dto.OwnerAfterCreationDto;
import com.example.construction_project.dto.OwnerCreateDto;
import com.example.construction_project.entity.Owner;
import com.example.construction_project.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @GetMapping
    public List<Owner> getAll(){
        return new ArrayList<>(ownerService.getAll());
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable("id") UUID id){
        return ownerService.getOwnerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOwnerById(@PathVariable("id") UUID id){
        ownerService.deleteOwnerById(id);
    }

    @PutMapping("/updateTellNumber")
    public Owner updateOwnerByTellNumber(
            @RequestParam("tellNumber") String tellNumber,
            @RequestParam("newTellNumber") String newTellNumber) {
        return ownerService.updateOwnerByTellNumber(tellNumber, newTellNumber);
     }

    @PostMapping
    public OwnerAfterCreationDto createOwner(@RequestBody OwnerCreateDto ownerCreateDto){
        return ownerService.createOwner(ownerCreateDto);
    }
}
