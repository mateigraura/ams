package com.business.services;

import com.business.repositories.CheckinRepository;
import com.domain.entities.Checkin;

import java.util.List;

public class DepartureService {

    private final CheckinRepository checkinRepository;

    public DepartureService(final CheckinRepository checkinRepository) {
        this.checkinRepository = checkinRepository;
    }

    public List<Checkin> getCheckinFlights() throws Exception {
        return checkinRepository.getMany();
    }
}
