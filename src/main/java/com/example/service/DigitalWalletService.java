package com.example.service;

import com.example.model.CardRef;
import com.example.model.ReferenceRequest;
import com.example.model.ReferenceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class DigitalWalletService {

    private final RestTemplate digitalWalletClient;

    public DigitalWalletService(RestTemplateBuilder builder, @Value("${digital-wallet.url:localhost}") String url) {
        digitalWalletClient = builder.rootUri(url).build();
    }

    public Collection<CardRef> getCardRefs(List<Long> ids) {
        return digitalWalletClient.postForObject("/api/v1/references", new ReferenceRequest(ids), ReferenceResponse.class).getCardRefs();
    }
}
