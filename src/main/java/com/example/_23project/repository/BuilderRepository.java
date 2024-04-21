package com.example._23project.repository;

import com.example._23project.entity.Builder;
import com.example._23project.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BuilderRepository extends JpaRepository<Builder, UUID> {
    Builder getBuilderById(UUID id);
    Builder findByTellNumber(int tellNumber);
    void deleteBuilderById(UUID id);
    String updateBuilderByTellNumber(int tellNumber, int newTellNumber);
    List<Builder> findByBuilderDescription(String description);
}
