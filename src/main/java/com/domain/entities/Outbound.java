package com.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class Outbound {

    Integer id;
    Date flightDate;
    Time departureTime;
    Time arrivalTime;
    Flight flight;
    Integer flightId;

    public Outbound(
            Integer id,
            Date flightDate,
            Time departureTime,
            Time arrivalTime,
            Integer flightId,
            Flight flight
    ) {
        this.id = id;
        this.flightDate = flightDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightId = flightId;
        this.flight = flight;
    }
}
