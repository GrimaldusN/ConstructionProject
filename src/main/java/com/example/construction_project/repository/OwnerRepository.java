package com.example.construction_project.repository;

import com.example.construction_project.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, UUID> {
    Owner getOwnerById(UUID id);
    void deleteOwnerById(UUID id);
    Owner findByTellNumber(String tellNumber);
}
