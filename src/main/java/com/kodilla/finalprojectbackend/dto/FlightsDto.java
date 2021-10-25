package com.kodilla.finalprojectbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FlightsDto {
    private long id;
    private long weatherId;
    private String originPlace;
    private String destinationPlace;
}
