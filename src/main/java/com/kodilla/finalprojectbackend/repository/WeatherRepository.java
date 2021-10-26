package com.kodilla.finalprojectbackend.repository;

import com.kodilla.finalprojectbackend.domain.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
    @Override
    List<Weather> findAll();
}
