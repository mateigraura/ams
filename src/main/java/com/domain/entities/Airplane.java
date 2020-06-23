package com.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Airplane {

    Integer id;
    String model;
    String manufacturer;
    Integer fuelCapacity;
    Integer passengerCapacity;
    Integer maxRange;
    Date manufactureDate;
    Date lastMaintenance;

    public Airplane(
            Integer id,
            String model,
            String manufacturer,
            Integer fuelCapacity,
            Integer passengerCapacity,
            Integer maxRange,
            Date manufactureDate,
            Date lastMaintenance
    ) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.fuelCapacity = fuelCapacity;
        this.passengerCapacity = passengerCapacity;
        this.maxRange = maxRange;
        this.manufactureDate = manufactureDate;
        this.lastMaintenance = lastMaintenance;
    }
}
