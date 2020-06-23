package com.domain.repositories;

import com.business.repositories.CheckinRepository;
import com.domain.entities.Checkin;
import com.domain.entities.enumerators.CheckinStatus;
import com.domain.repositories.base.BaseRepository;
import com.presentation.config.DbConnection;

import java.sql.ResultSet;
import java.util.List;

public class CheckinRepositoryImpl
        extends BaseRepository
        implements CheckinRepository {

    public CheckinRepositoryImpl() throws Exception {
        super(DbConnection.getInstance().getConnection());
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
    public List<Checkin> getMany() throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Checkin getCheckinByFlightId(Integer flightId) throws Exception {
        Object[] params = {flightId};
        ResultSet resultSet = executionResult("{call getCheckinByFlightId(?)}", params);

        if (!resultSet.isBeforeFirst()) {
            throw new Exception("No user found for this email !");
        } else {
            resultSet.next();
            return new Checkin(
                    resultSet.getInt(1),
                    CheckinStatus.getEnum(resultSet.getInt(2)),
                    resultSet.getInt(3)
            );
        }
    }
}
