package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CardEntity {
    @Id
    private Long id;
    private String cardNumber;
    private String currency;
}
