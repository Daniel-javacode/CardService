package com.example.service;

import com.example.entity.CardEntity;
import com.example.model.CardInfo;
import com.example.model.CardRef;
import com.example.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardInfoService {
    private final SmartMoneyService smartMoney;
    private final DigitalWalletService digitalWallet;
    private final CardRepository repository;

    public Collection<CardInfo> cardList() {
        var list = repository.findAll();
        var cardIds = list.stream().map(CardEntity::getId).toList();
        var cardRefs = digitalWallet.getCardRefs(cardIds).stream().collect(Collectors.toConcurrentMap(CardRef::getCardId, CardRef::getRef));
        return list.parallelStream()
                .map(entity -> CardInfo.builder()
                        .id(entity.getId())
                        .cardNumber(entity.getCardNumber().replaceAll("\\b(\\d{6})(\\d{6})(\\d{4})", "$1XXXXXX$3"))
                        .currency(entity.getCurrency())
                        .build())
                .peek(cardInfo -> cardInfo.setDigitalWalletAccountId(cardRefs.get(cardInfo.getId())))
                .peek(cardInfo -> cardInfo.setBalance(smartMoney.getBalance(cardInfo.getId())))
                .toList();

    }
}
