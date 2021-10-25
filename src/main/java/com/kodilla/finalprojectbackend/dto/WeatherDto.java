package com.kodilla.finalprojectbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WeatherDto {
    private long id;
    private String originPlace;
    private int temperature;
}
