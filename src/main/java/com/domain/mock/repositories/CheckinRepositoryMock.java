package com.domain.mock.repositories;

import com.business.repositories.CheckinRepository;
import com.domain.entities.Checkin;
import com.domain.mock.data.DepartureDataMock;

import java.util.List;

public class CheckinRepositoryMock implements CheckinRepository {

    private static List<Checkin> checkinFlights;

    public CheckinRepositoryMock() {
        checkinFlights = new DepartureDataMock().getCheckinFlights();
    }

    @Override
    public Checkin get(Integer integer) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Checkin insert(Checkin checkin) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Checkin update(Checkin checkin) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Checkin remove(Checkin checkin) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public List<Checkin> getMany() {
        return checkinFlights;
    }

    @Override
    public Checkin getCheckinByFlightId(Integer flightId) throws Exception {
        throw new Exception("Not impl");
    }
}
