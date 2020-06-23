package com.domain.entities;

import com.domain.entities.enumerators.FlightStatus;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class Flight {

    Integer id;
    String source;
    String destination;
    FlightStatus flightStatus;
    String callSign;
    Integer passengers;
    Time delay;
    Integer airlineCode;
    Integer planeId;

    public Flight(
            Integer id,
            String source,
            String destination,
            FlightStatus flightStatus,
            String callSign,
            Integer passengers,
            Time delay,
            Integer airlineCode,
            Integer planeId
    ) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.flightStatus = flightStatus;
        this.callSign = callSign;
        this.passengers = passengers;
        this.delay = delay;
        this.airlineCode = airlineCode;
        this.planeId = planeId;
    }
}
