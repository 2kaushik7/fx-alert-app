package com.systemsai.fxalert.util;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.systemsai.fxalert.model.Alert;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RateListener {

    private final AlertManager manager;

    @KafkaListener(topics = "fx.rates.updates", groupId = "alert-service")
    public void consume(String message) {
        // message is like "INR:83.4"
        String[] parts = message.split(":");
        if (parts.length != 2) return;

        String pair = "USD" + parts[0]; // USD is base
        double rate = Double.parseDouble(parts[1]);

        List<Alert> triggered = manager.getTriggeredAlerts(pair, rate);

        for (Alert alert : triggered) {
            System.out.println("Triggering alert for " + alert.getEmail());
            // TODO: send to notification-lambda via queue, SNS, SQS, or HTTP
        }
    }
}

