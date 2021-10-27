package com.kodilla.finalprojectbackend.domain;

import com.kodilla.finalprojectbackend.repository.FlightsRepository;
import com.kodilla.finalprojectbackend.repository.WeatherRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FlightsRepositoryTestSuite {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    FlightsRepository flightsRepository;

    private Weather weather;
    private Flights flights;

    private void createData() {
        weather = new Weather(0,"originPlace",30);
        flights = new Flights(0,null,"originPlace","destinationPlace");
    }

    private void deleteData() {
        weatherRepository.delete(weather);
        flightsRepository.delete(flights);
    }

    private void prepareDataAndSave() {
        weather = new Weather(0,"originPlace",30);
        flights = new Flights(0,null,"originPlace","destinationPlace");
        flights.setWeather(weather);
        weatherRepository.save(weather);
        flightsRepository.save(flights);
    }

    @Test
    public void testFlightsRepositorySave() {
        //Given
        createData();

        //When
        flightsRepository.save(flights);

        //Then
        assertNotEquals(0, flights.getId());

        //CleanUp
        deleteData();
    }

    @Test
    public void testCartRepositoryGet() {
        //Given
        prepareDataAndSave();

        //When
        Optional<Flights> result = flightsRepository.findById(flights.getId());

        //Then
        assertTrue(result.isPresent());
        assertEquals("originPlace", result.orElse(new Flights()).getOriginPlace());

        //CleanUp
        deleteData();
    }

    @Test
    public void testCartRepositoryUpdate() {
        //Given
        prepareDataAndSave();

        //When
        Weather newWeather = new Weather(0,"newOriginPlace",weather.getTemperature());
        weatherRepository.save(newWeather);
        flights.setWeather(newWeather);
        flightsRepository.save(flights);

        //Then
        assertEquals(flights.getWeather().getId(), newWeather.getId());

        //CleanUp
        deleteData();
    }

    @Test
    public void testCartRepositoryDelete() {
        //Given
        prepareDataAndSave();

        //When
        flightsRepository.deleteById(flights.getId());
        Optional<Flights> resultById = flightsRepository.findById(flights.getId());
        List<Flights> result = flightsRepository.findAll();

        //Then
        assertFalse(resultById.isPresent());
        assertEquals(0,result.size());
    }
}
