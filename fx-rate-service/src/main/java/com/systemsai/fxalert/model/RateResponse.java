package com.systemsai.fxalert.model;

import java.util.Map;

import lombok.Data;

@Data
public class RateResponse {
    private String base;
    private String date;
    private Map<String, Double> rates;
}
