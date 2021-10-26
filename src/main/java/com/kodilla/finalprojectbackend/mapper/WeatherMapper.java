package com.kodilla.finalprojectbackend.mapper;

import com.kodilla.finalprojectbackend.domain.Weather;
import com.kodilla.finalprojectbackend.dto.WeatherDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WeatherMapper extends EntityMapper<Weather,WeatherDto>{

    @Override
    public Weather toEntity(WeatherDto weatherDto)
    {
        return new Weather(weatherDto.getId(),weatherDto.getOriginPlace(),
                weatherDto.getTemperature());
    }

    @Override
    public WeatherDto toDto(Weather weather)
    {
        return new WeatherDto(weather.getId(),
                weather.getOriginPlace(),weather.getTemperature());
    }
}
