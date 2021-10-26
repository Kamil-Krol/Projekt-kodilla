package com.kodilla.finalprojectbackend.repository;

import com.kodilla.finalprojectbackend.domain.Flights;
import org.springframework.data.repository.CrudRepository;

public interface FlightsRepository extends CrudRepository<Flights, Long> {
}
