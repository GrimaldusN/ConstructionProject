package com.example.construction_project.repository;

import com.example.construction_project.entity.Material_quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MaterialQuantityRepository extends JpaRepository<Material_quantity, UUID> {
    Material_quantity getMaterialById(UUID id);
    Optional<Material_quantity> findById(UUID id);
    void deleteMaterialById(UUID id);
}
