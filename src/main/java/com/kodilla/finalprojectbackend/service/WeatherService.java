package com.kodilla.finalprojectbackend.service;

import com.kodilla.finalprojectbackend.domain.Weather;
import com.kodilla.finalprojectbackend.dto.WeatherDto;
import com.kodilla.finalprojectbackend.mapper.WeatherMapper;
import com.kodilla.finalprojectbackend.repository.WeatherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WeatherService {

    private final WeatherMapper weatherMapper;
    private final WeatherRepository weatherRepository;

    public List<WeatherDto> getAll() {
        return weatherMapper.toDtoList(weatherRepository.findAll());
    }

    public WeatherDto getById(long id)  {
        return weatherRepository.findById(id).map(weatherMapper::toDto).orElse(null);
    }

    @Transactional
    public WeatherDto create(final WeatherDto weatherDto) {
        if (weatherDto.getId() != 0) return Optional.ofNullable(weatherDto).get();
        return saveAndMapToDto(weatherDto);
    }

    @Transactional
    public void delete(final long id)  {
        weatherRepository.findById(id).orElse(null);
        weatherRepository.deleteById(id);
    }

    @Transactional
    public WeatherDto update(final WeatherDto weatherDto){
        weatherRepository.findById(weatherDto.getId()).orElse(Optional.ofNullable(weatherDto).get());
        return saveAndMapToDto(weatherDto);
    }

    private WeatherDto saveAndMapToDto(final WeatherDto weatherDto) {
        Weather weather = weatherRepository.save(weatherMapper.toEntity(weatherDto));
        return weatherMapper.toDto(weather);
    }
}
