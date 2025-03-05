package com.example.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class CardInfo {
    private Long id;
    private String cardNumber;
    private String currency;
    private BigDecimal balance;
    private UUID digitalWalletAccountId;
}
