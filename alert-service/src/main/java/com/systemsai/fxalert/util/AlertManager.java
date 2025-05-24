package com.systemsai.fxalert.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.systemsai.fxalert.model.Alert;

@Service
public class AlertManager {
    private final List<Alert> alerts = new CopyOnWriteArrayList<>();

    public void addAlert(Alert alert) {
        alerts.add(alert);
    }

    public List<Alert> getAllAlerts() {
        return alerts;
    }

    public List<Alert> getTriggeredAlerts(String pair, double newRate) {
        List<Alert> toNotify = new ArrayList<>();
        for (Alert alert : alerts) {
            if (!alert.isTriggered()
                && alert.getPair().equalsIgnoreCase(pair)
                && newRate >= alert.getThreshold()) {
                alert.setTriggered(true); // mark as triggered
                toNotify.add(alert);
            }
        }
        return toNotify;
    }
}

