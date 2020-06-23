package com.domain.repositories;

import com.business.repositories.UserRepository;
import com.domain.entities.User;
import com.domain.repositories.base.BaseRepository;
import com.presentation.config.DbConnection;

import java.sql.ResultSet;
import java.util.List;

public class UserRepositoryImpl
        extends BaseRepository
        implements UserRepository {

    public UserRepositoryImpl() throws Exception {
        super(DbConnection.getInstance().getConnection());
    }

    @Override
    public User getByEmail(String email) throws Exception {
        Object[] params = {email};
        ResultSet resultSet = executionResult("{call getUserByEmail(?)}", params);

        if (!resultSet.isBeforeFirst()) {
            throw new Exception("No user found for this email !");
        } else {
            resultSet.next();
            return new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
        }
    }

    @Override
    public User get(Integer integer) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public User insert(User user) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public User update(User user) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public User remove(User user) throws Exception {
        throw new Exception("Not impl");
    }

    @Override
    public List<User> getMany() throws Exception {
        throw new Exception("Not impl");
    }
}
