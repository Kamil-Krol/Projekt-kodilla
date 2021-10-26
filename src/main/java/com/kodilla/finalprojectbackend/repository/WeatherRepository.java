package com.kodilla.finalprojectbackend.repository;

import com.kodilla.finalprojectbackend.domain.Weather;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<Weather, Long> {
}
