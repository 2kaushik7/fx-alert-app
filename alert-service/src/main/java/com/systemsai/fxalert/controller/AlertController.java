package com.systemsai.fxalert.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systemsai.fxalert.model.Alert;
import com.systemsai.fxalert.util.AlertManager;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertManager manager;

    @PostMapping
    public ResponseEntity<String> createAlert(@RequestBody Alert alert) {
        manager.addAlert(alert);
        return ResponseEntity.ok("Alert created");
    }

    @GetMapping
    public List<Alert> listAlerts() {
        return manager.getAllAlerts();
    }
}
