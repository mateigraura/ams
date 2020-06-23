package com.domain.repositories;

import com.business.repositories.OutboundRepository;
import com.domain.entities.Flight;
import com.domain.entities.Outbound;
import com.domain.entities.enumerators.FlightStatus;
import com.domain.repositories.base.BaseRepository;
import com.presentation.config.DbConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OutboundRepositoryImpl
        extends BaseRepository
        implements OutboundRepository {

    public OutboundRepositoryImpl() throws Exception {
        super(DbConnection.getInstance().getConnection());
    }

    @Override
    public Outbound get(Integer integer) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Outbound insert(Outbound outbound) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Outbound update(Outbound outbound) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Outbound remove(Outbound outbound) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public List<Outbound> getMany() throws Exception {
        ResultSet resultSet = executionResult("{call getOutboundFlights()}", null);

        if (!resultSet.isBeforeFirst()) {
            throw new Exception("No inbound flights found !");
        } else {
            List<Outbound> outboundFlights = new ArrayList<>();
            while (resultSet.next()) {
                outboundFlights.add(new Outbound(
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
            return outboundFlights;
        }
    }
}
