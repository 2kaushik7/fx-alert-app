package com.systemsai.fxalert.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systemsai.fxalert.service.RateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rates")
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;

    @GetMapping
    public Map<String, Double> getAllRates() {
        return rateService.getRates();
    }

    @GetMapping("/{pair}")
    public Double getRate(@PathVariable String pair) {
        return rateService.getRates().getOrDefault(pair.toUpperCase(), null);
    }
}
