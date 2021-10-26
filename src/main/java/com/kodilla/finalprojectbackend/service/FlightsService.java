package com.kodilla.finalprojectbackend.service;

import com.kodilla.finalprojectbackend.domain.Flights;
import com.kodilla.finalprojectbackend.domain.Weather;
import com.kodilla.finalprojectbackend.dto.FlightsDto;
import com.kodilla.finalprojectbackend.dto.WeatherDto;
import com.kodilla.finalprojectbackend.mapper.FlightsMapper;
import com.kodilla.finalprojectbackend.repository.FlightsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FlightsService {

    private final FlightsMapper flightsMapper;
    private final FlightsRepository flightsRepository;

    public List<FlightsDto> getAll() {
        return flightsMapper.toDtoList(flightsRepository.findAll());
    }

    public FlightsDto getById(long id)  {
        return flightsRepository.findById(id).map(flightsMapper::toDto).orElse(null);
    }

    @Transactional
    public FlightsDto create(final FlightsDto flightsDto) {
        if (flightsDto.getId() != 0) return Optional.ofNullable(flightsDto).get();
        return saveAndMapToDto(flightsDto);
    }

    @Transactional
    public void delete(final long id)  {
        flightsRepository.findById(id).orElse(null);
        flightsRepository.deleteById(id);
    }

    @Transactional
    public FlightsDto update(final FlightsDto flightsDto){
        flightsRepository.findById(flightsDto.getId()).orElse(Optional.ofNullable(flightsDto).get());
        return saveAndMapToDto(flightsDto);
    }

    private FlightsDto saveAndMapToDto(final FlightsDto flightsDto) {
        Flights flights = flightsRepository.save(flightsMapper.toEntity(flightsDto));
        return flightsMapper.toDto(flights);
    }
}
