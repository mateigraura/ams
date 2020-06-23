package com.domain.entities;

import com.domain.entities.enumerators.CheckinStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Checkin {

    Integer id;
    CheckinStatus checkinStatus;
    Flight flight;
    Integer flightId;

    public Checkin(
            Integer id,
            CheckinStatus checkinStatus,
            Integer flightId
    ) {
        this.id = id;
        this.checkinStatus = checkinStatus;
        this.flightId = flightId;
    }
}
