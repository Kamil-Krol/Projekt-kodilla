package com.kodilla.finalprojectbackend.mapper;

import com.kodilla.finalprojectbackend.domain.Flights;
import com.kodilla.finalprojectbackend.dto.FlightsDto;
import com.kodilla.finalprojectbackend.repository.WeatherRepository;

public class FlightsMapper extends EntityMapper<Flights, FlightsDto>{

    WeatherRepository weatherRepository;

    @Override
    public Flights toEntity(FlightsDto flightsDto)
    {
        return new Flights(flightsDto.getId(),
                weatherRepository.findById(flightsDto.getWeatherId()).orElse(null),
                flightsDto.getOriginPlace(),flightsDto.getDestinationPlace());
    }

    @Override
    public FlightsDto toDto(Flights flights)
    {
        return  new FlightsDto(flights.getId(),
                flights.getWeather().getId(),
                flights.getOriginPlace(),flights.getDestinationPlace());
    }


}
