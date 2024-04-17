package com.example._23project.repository;

import com.example._23project.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {
    Building getBuildingById(UUID id);
    String deleteBuildingById(UUID id);
    Building findByBuildingDescription(String description);
}
