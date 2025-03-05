package com.example.model;

import lombok.Data;

import java.util.Collection;

@Data
public class ReferenceResponse {
    private Collection<CardRef> cardRefs;
}
