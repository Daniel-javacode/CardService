package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReferenceRequest {
    private List<Long> cardIds;
}
