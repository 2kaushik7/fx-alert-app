package com.systemsai.fxalert.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.systemsai.fxalert.model.RateResponse;

@Component
public class ExchangeRateClient {
	private final RestTemplate restTemplate = new RestTemplate();
	public Map<String,Double> getRates(String base){
		String url = "";
		//ResponseEntity<RateResponse> response = restTemplate.getForEntity(url, RateResponse.class);
		//return response.getBody() != null ? response.getBody().getRates() : new HashMap<>();
		Map<String,Double> res = new HashMap<>();
		res.put("USD", 83.4);
		res.put("GBP", 104.4);
		return res;
	}
}
