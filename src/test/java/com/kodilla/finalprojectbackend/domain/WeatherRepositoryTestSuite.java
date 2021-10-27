package com.kodilla.finalprojectbackend.domain;



import com.kodilla.finalprojectbackend.repository.WeatherRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WeatherRepositoryTestSuite {

    @Autowired
    WeatherRepository weatherRepository;

    private Weather weather;

    private void createData() {
        weather = new Weather(0,"originPlace",30);
    }

    private void deleteData() {
        weatherRepository.delete(weather);
    }

    private void prepareDataAndSave() {
        weather = new Weather(0,"originPlace",30);
        weatherRepository.save(weather);
    }

    @Test
    public void testWeatherRepositorySave() {
        //Given
        createData();

        //When
        weatherRepository.save(weather);

        //Then
        assertNotEquals(0, weather.getId());

        //CleanUp
        deleteData();
    }

    @Test
    public void testWeatherRepositoryGet() {
        //Given
        prepareDataAndSave();

        //When
        Optional<Weather> result = weatherRepository.findById(weather.getId());

        //Then
        assertTrue(result.isPresent());
        assertEquals("originPlace", result.orElse(new Weather()).getOriginPlace());

        //CleanUp
        deleteData();
    }

    @Test
    public void testWeatherRepositoryUpdate() {
        //Given
        prepareDataAndSave();

        //When
        Weather newWeather = new Weather(0, "newOriginPlace", weather.getTemperature());
        weatherRepository.save(newWeather);

        //Then
        assertEquals(weather.getId(), newWeather.getId());

        //CleanUp
        deleteData();
    }

    @Test
    public void testWeatherRepositoryDelete() {
        //Given
        prepareDataAndSave();

        //When
        weatherRepository.deleteById(weather.getId());
        Optional<Weather> resultById = weatherRepository.findById(weather.getId());
        List<Weather> result = weatherRepository.findAll();

        //Then
        assertFalse(resultById.isPresent());
        assertEquals(0,result.size());
    }

}
