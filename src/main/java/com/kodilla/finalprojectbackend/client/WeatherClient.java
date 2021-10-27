package com.kodilla.finalprojectbackend.client;

import com.kodilla.finalprojectbackend.config.AppConfig;
import com.kodilla.finalprojectbackend.dto.WeatherDto;
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
public class WeatherClient {
    private final AppConfig appConfig;
    private final RestTemplate restTemplate;

    public List<WeatherDto> getWeatherList()
    {
        URI uri = UriComponentsBuilder.fromHttpUrl(appConfig.getApiWeatherEndpoint())
                .queryParam("key", appConfig.getApiWeatherKey())
                .build()
                .encode()
                .toUri();

        WeatherDto[] weatherDtos = restTemplate.getForObject(uri, WeatherDto[].class);
        return weatherDtos != null ? Arrays.asList(weatherDtos) : new ArrayList<>();

    }
}
