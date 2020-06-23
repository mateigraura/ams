package com.domain.repositories;

import com.business.repositories.FlightRepository;
import com.domain.entities.Flight;
import com.domain.entities.enumerators.FlightStatus;
import com.domain.repositories.base.BaseRepository;
import com.presentation.config.DbConnection;

import java.sql.ResultSet;
import java.util.List;

public class FlightRepositoryImpl
        extends BaseRepository
        implements FlightRepository {

    public FlightRepositoryImpl() throws Exception {
        super(DbConnection.getInstance().getConnection());
    }

    @Override
    public Flight get(Integer id) throws Exception {
        Object[] params = {id};
        ResultSet resultSet = executionResult("{call getFlightById(?)}", params);

        if (!resultSet.isBeforeFirst()) {
            throw new Exception("No flight found for this id !");
        } else {
            resultSet.next();
            return new Flight(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    FlightStatus.getEnum(resultSet.getInt(4)),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getTime(7),
                    resultSet.getInt(8),
                    resultSet.getInt(9)
            );
        }
    }

    @Override
    public Flight insert(Flight flight) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Flight update(Flight flight) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Flight remove(Flight flight) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public List<Flight> getMany() throws Exception {
        throw new Exception("Not impl");
    }
}
