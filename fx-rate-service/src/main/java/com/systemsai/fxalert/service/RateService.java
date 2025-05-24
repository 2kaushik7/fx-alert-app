package com.systemsai.fxalert.service;

import java.util.Map;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.systemsai.fxalert.util.ExchangeRateClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RateService {

    private final ExchangeRateClient client;
    private final KafkaTemplate<String, String> kafka;

    @Scheduled(fixedRate = 60000)
    public void fetchAndPublishRates() {
        Map<String, Double> rates = client.getRates("USD");

        for (Map.Entry<String, Double> entry : rates.entrySet()) {
            String payload = entry.getKey() + ":" + entry.getValue();
            kafka.send("fx.rates.updates", payload);
        }

        log.info("Published FX rates to Kafka.");
    }

    public Map<String, Double> getRates() {
        return client.getRates("USD");
    }
}

