package com.kodilla.finalprojectbackend.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Flights {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @NotNull
    @JoinColumn(name = "weatherId")
    private Weather weather;

    @NotNull
    private String originPlace;

    @NotNull
    private String destinationPlace;




}
