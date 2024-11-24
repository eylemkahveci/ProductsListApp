package com.project.productapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

//to get the gold price from a real time data source
@Service
public class GoldPriceService {

    private final String GOLD_API_URL = "https://www.goldapi.io/api/XAU/USD";
    private static final String API_KEY = "goldapi-1kszvsm3vwstga-io";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public GoldPriceService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

}
