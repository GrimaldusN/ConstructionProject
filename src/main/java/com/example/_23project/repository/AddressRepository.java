package com.example._23project.repository;

import com.example._23project.entity.Address;
import com.example._23project.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    Address getAddressById(UUID id);
    String deleteAddressById(UUID id);
    List<Address> findByAddressDescription(String description);
}
