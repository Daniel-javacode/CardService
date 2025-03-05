package com.example.model;

import lombok.Data;

import java.util.UUID;

@Data
public class CardRef {
    private Long cardId;
    private UUID ref;
}
