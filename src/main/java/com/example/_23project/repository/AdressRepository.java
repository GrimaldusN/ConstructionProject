package com.example._23project.repository;

import com.example._23project.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdressRepository extends JpaRepository<Adress, UUID> {
    Adress getById(UUID id);
}
