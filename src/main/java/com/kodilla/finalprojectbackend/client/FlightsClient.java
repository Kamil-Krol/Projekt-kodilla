package com.kodilla.finalprojectbackend.client;

import com.kodilla.finalprojectbackend.config.AppConfig;
import com.kodilla.finalprojectbackend.dto.FlightsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class FlightsClient {
    private final AppConfig appConfig;
    private final RestTemplate restTemplate;

    public List<FlightsDto> getFlightsList(String locale, String destination)
    {
            URI uri = UriComponentsBuilder.fromHttpUrl(appConfig.getApiFlightsEndpoint())
                    .queryParam("key", appConfig.getApiFlightsKey())
                    .build()
                    .encode()
                    .toUri();

            FlightsDto[] flightsDtos = restTemplate.getForObject(uri, FlightsDto[].class);
            return flightsDtos != null ? Arrays.asList(flightsDtos) : new ArrayList<>();

    }
}
