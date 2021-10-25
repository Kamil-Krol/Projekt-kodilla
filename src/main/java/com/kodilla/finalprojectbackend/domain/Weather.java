package com.kodilla.finalprojectbackend.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Weather {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String originPlace;

    @NotNull
    private int temperature;
}
