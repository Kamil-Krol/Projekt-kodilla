package com.kodilla.finalprojectbackend.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AppConfig {

    @Value("${api.flights.endpoint}")
    private String apiFlightsEndpoint;

    @Value("${api.flights.key}")
    private String apiFlightsKey;

    @Value("${api.weather.endpoint}")
    private String apiWeatherEndpoint;

    @Value("${api.weather.key}")
    private String apiWeatherKey;
}
