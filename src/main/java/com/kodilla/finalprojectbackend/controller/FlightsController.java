package com.kodilla.finalprojectbackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("v1/flights")
public class FlightsController {
    private final FlightsService flightsService;

    @GetMapping
    public List<FlightsDto> get() {
        return flightsService.getAll();
    }

    @GetMapping("/{id}")
    public FlightsDto get(@PathVariable long id) {
        return flightsService.getById(id);
    }

    @PostMapping
    public FlightsDto create(@RequestBody FlightsDto flightsDto) {
        return flightsService.create(flightsDto);
    }

    @PutMapping
    public FlightsDto update(@RequestBody FlightsDto flightsDto) {
        return flightsService.update(flightsDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id)  {
        flightsService.delete(id);
    }
}
