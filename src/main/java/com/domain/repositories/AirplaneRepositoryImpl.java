package com.domain.repositories;

import com.business.repositories.AirplaneRepository;
import com.domain.entities.Airplane;
import com.domain.repositories.base.BaseRepository;
import com.presentation.config.DbConnection;

import java.sql.ResultSet;
import java.util.List;

public class AirplaneRepositoryImpl
        extends BaseRepository
        implements AirplaneRepository {

    public AirplaneRepositoryImpl() throws Exception {
        super(DbConnection.getInstance().getConnection());
    }

    @Override
    public Airplane get(Integer id) throws Exception {
        Object[] params = {id};
        ResultSet resultSet = executionResult("{call getPlaneById(?)}", params);

        if (!resultSet.isBeforeFirst()) {
            throw new Exception("No user found for this email !");
        } else {
            resultSet.next();
            return new Airplane(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getDate(7),
                    resultSet.getDate(8)
            );
        }
    }

    @Override
    public Airplane insert(Airplane airplane) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Airplane update(Airplane airplane) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Airplane remove(Airplane airplane) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public List<Airplane> getMany() throws Exception {
        throw new Exception("Not impl");
    }
}
