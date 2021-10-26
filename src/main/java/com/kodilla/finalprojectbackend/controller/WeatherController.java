package com.kodilla.finalprojectbackend.controller;


import com.kodilla.finalprojectbackend.dto.WeatherDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public List<WeatherDto> get() {
        return weatherService.getAll();
    }

    @GetMapping("/{id}")
    public WeatherDto get(@PathVariable long id) {
        return weatherService.getById(id);
    }

    @PostMapping
    public WeatherDto create(@RequestBody WeatherDto weatherDto) {
        return weatherService.create(weatherDto);
    }t

    @PutMapping
    public WeatherDto update(@RequestBody WeatherDto weatherDto) {
        return weatherService.update(weatherDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id)  {
        weatherService.delete(id);
    }
}
