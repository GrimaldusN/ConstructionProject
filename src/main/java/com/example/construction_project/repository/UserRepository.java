package com.example.construction_project.repository;

import com.example.construction_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User getUserById(UUID id);
    User findUserByLogin(String login);
    void deleteUsersById(UUID id);
}
