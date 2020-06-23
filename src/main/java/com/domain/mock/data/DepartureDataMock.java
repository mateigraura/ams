package com.domain.mock.data;

import com.domain.entities.Checkin;
import com.domain.entities.Flight;
import com.domain.entities.enumerators.CheckinStatus;
import com.domain.entities.enumerators.FlightStatus;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class DepartureDataMock {

    private static List<Checkin> checkinFlights;

    public DepartureDataMock() {
        createMockCheckin();
    }

    public List<Checkin> getCheckinFlights() {
        return checkinFlights;
    }

    private void createMockCheckin() {
        checkinFlights = new ArrayList<>();

        for (int i = 0; i < 15; ++i) {
            Checkin checkin = new Checkin(
                    (i + 1) * 5,
                    CheckinStatus.CLOSED,
                    i * 2
            );
            checkin.setFlight(new Flight(
                    i * 2,
                    "LAX",
                    randString(4),
                    FlightStatus.WAITING_FOR_TAXI,
                    randString(6),
                    i * 10,
                    Time.valueOf("00:00:00"),
                    i * 3,
                    i * 9
            ));
            checkinFlights.add(checkin);
        }
    }

    private String randString(int n) {

        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (alpha.length() * Math.random());

            sb.append(alpha.charAt(index));
        }
        return sb.toString();
    }
}
