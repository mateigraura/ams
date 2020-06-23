package com.domain.repositories;

import com.business.repositories.InboundRepository;
import com.domain.entities.Flight;
import com.domain.entities.Inbound;
import com.domain.entities.enumerators.FlightStatus;
import com.domain.repositories.base.BaseRepository;
import com.presentation.config.DbConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InboundRepositoryImpl
        extends BaseRepository
        implements InboundRepository {

    public InboundRepositoryImpl() throws Exception {
        super(DbConnection.getInstance().getConnection());
    }

    @Override
    public Inbound get(Integer integer) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Inbound insert(Inbound inbound) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Inbound update(Inbound inbound) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Inbound remove(Inbound inbound) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public List<Inbound> getMany() throws Exception {
        ResultSet resultSet = executionResult("{call getInboundFlights()}", null);

        if (!resultSet.isBeforeFirst()) {
            throw new Exception("No inbound flights found !");
        } else {
            List<Inbound> inboundFlights = new ArrayList<>();
            while (resultSet.next()) {
                inboundFlights.add(new Inbound(
                        resultSet.getInt(1),
                        resultSet.getDate(2),
                        resultSet.getTime(3),
                        resultSet.getTime(4),
                        resultSet.getInt(5),
                        new Flight(
                                resultSet.getInt(6),
                                resultSet.getString(7),
                                resultSet.getString(8),
                                FlightStatus.getEnum(resultSet.getInt(9)),
                                resultSet.getString(10),
                                resultSet.getInt(11),
                                resultSet.getTime(12),
                                resultSet.getInt(13),
                                resultSet.getInt(14)
                        )
                ));
            }
            return inboundFlights;
        }
    }
}
