package com.example.controller;

import com.example.model.CardInfo;
import com.example.service.CardInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardInfoService cardInfoService;

    @GetMapping("/list")
    public Collection<CardInfo> cardList(){
        return cardInfoService.cardList();
    }
}
