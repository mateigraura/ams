package com.business.repositories;

import com.business.repositories.base.CrudRepository;
import com.domain.entities.Checkin;

public interface CheckinRepository extends CrudRepository<Checkin, Integer> {
    Checkin getCheckinByFlightId(Integer flightId) throws Exception;
}
