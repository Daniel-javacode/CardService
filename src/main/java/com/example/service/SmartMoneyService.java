package com.example.service;

import com.example.model.BalanceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Slf4j
@Service
public class SmartMoneyService {
    private final RestTemplate smartMoneyClient;

    public SmartMoneyService(RestTemplateBuilder builder, @Value("${smart-money.url:localhost}") String url){
        smartMoneyClient = builder.rootUri(url).build();
    }

    public BigDecimal getBalance(Long cardId) {
        var responseEntity = smartMoneyClient.getForEntity(String.format("/api/v1/%d/balance",cardId), BalanceResponse.class);
        if (responseEntity.getStatusCode().isError()){
            return null;
        }
        return responseEntity.getBody().getBalance();
    }
}
