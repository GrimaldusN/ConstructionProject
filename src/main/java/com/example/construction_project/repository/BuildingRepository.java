package com.example.construction_project.repository;

import com.example.construction_project.entity.Building;
import com.example.construction_project.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {
    Building getBuildingById(UUID id);
    Building getBuildingByName(String name);
    void deleteBuildingById(UUID id);
}
