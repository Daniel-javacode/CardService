package com.example.repository;

import com.example.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
