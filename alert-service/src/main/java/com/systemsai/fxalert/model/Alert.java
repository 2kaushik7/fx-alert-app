package com.systemsai.fxalert.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    private String pair;        // e.g. USDINR
    private double threshold;   // e.g. 83.5
    private String email;       // user@example.com
    private boolean triggered;  // prevent duplicate triggers
}

