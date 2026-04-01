package com.weather.microservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.microservice.dto.WeatherResponse;

// Marks this class as a Spring-managed component responsible for business logic.
@Service
public class WeatherService {

    // Injects the external API URL explicitly defined in application.yml.
    @Value("${weather.api.url}")
    private String apiUrl;

    // Executes the HTTP GET request and maps the incoming JSON directly to the DTO.
    public WeatherResponse getWeatherData() {
        // Instantiates Spring's synchronous HTTP client for web requests.
        RestTemplate restTemplate = new RestTemplate();

        // Fetches the JSON from apiUrl and uses the Jackson library to deserialize it
        // into WeatherResponse.
        return restTemplate.getForObject(apiUrl, WeatherResponse.class);
    }
}