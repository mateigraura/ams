package com.domain.repositories.base;

import java.sql.*;

public class BaseRepository {
    protected Connection connection;

    public BaseRepository(Connection connection) {
        this.connection = connection;
    }

    protected ResultSet executionResult(String sqlProcedure, Object[] params) throws Exception {
        CallableStatement cs = connection.prepareCall(sqlProcedure);

        if (params != null) {
            for (int i = 0; i < params.length; ++i) {
                if (params[i] instanceof Integer) {
                    cs.setInt((i + 1), (Integer) params[i]);
                }
                if (params[i] instanceof String) {
                    cs.setString((i + 1), (String) params[i]);
                }
                if (params[i] instanceof Date) {
                    cs.setDate((i + 1), (Date) params[i]);
                }
            }
        }
        return cs.executeQuery();
    }
}
