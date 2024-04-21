package com.example._23project.repository;

import com.example._23project.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, UUID> {
    Owner getOwnerById(UUID id);
    Owner getOwnerByAddressName(String addressName);
    void deleteOwnerById(UUID id);
    List<Owner> findByOwnerDescription(String description);

    Owner findByTellNumber(int tellNumber);
}
