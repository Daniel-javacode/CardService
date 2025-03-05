package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByUsername(String username);
}
