package com.domain.repositories;

import com.business.repositories.AirlinesRepository;
import com.domain.entities.Airline;
import com.domain.repositories.base.BaseRepository;
import com.presentation.config.DbConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AirlinesRepositoryImpl
        extends BaseRepository
        implements AirlinesRepository {

    public AirlinesRepositoryImpl() throws Exception {
        super(DbConnection.getInstance().getConnection());
    }

    @Override
    public List<Airline> getMany() throws Exception {
        ResultSet resultSet = executionResult("{call getAirlines()}", null);

        if (!resultSet.isBeforeFirst()) {
            throw new Exception("No airlines found !");
        } else {
            List<Airline> airlines = new ArrayList<>();
            while (resultSet.next()) {
                airlines.add(new Airline(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));
            }
            return airlines;
        }
    }

    @Override
    public Airline get(Integer id) throws Exception {
        Object[] params = {id};
        ResultSet resultSet = executionResult("{call getAirlineById(?)}", params);

        if (!resultSet.isBeforeFirst()) {
            throw new Exception("No airline found for this key !");
        } else {
            resultSet.next();
            return new Airline(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        }
    }

    @Override
    public Airline insert(Airline airline) throws Exception {
        Object[] params = {
                airline.getName(),
                airline.getAlliance(),
                airline.getMainHub()
        };

        ResultSet resultSet = executionResult("{call addAirline(?, ?, ?)}", params);
        if (!resultSet.isBeforeFirst()) {
            throw new Exception("Couldn't insert airline");
        } else {
            resultSet.next();
            airline.setCode(resultSet.getInt(1));
            return airline;
        }
    }

    @Override
    public Airline update(Airline airline) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public Airline remove(Airline airline) throws Exception {
        throw new Exception("Not impl");
    }
}
