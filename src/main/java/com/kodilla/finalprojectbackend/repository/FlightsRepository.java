package com.kodilla.finalprojectbackend.repository;

import com.kodilla.finalprojectbackend.domain.Flights;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepository extends CrudRepository<Flights, Long> {
    @Override
    List<Flights> findAll();
}
