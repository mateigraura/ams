package com.presentation.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private String url;
    private String username;
    private String password;
    private Connection connection;

    private static boolean initTriggered;

    private static DbConnection instance;
    
    public static void init(
            final String url,
            final String username,
            final String password
    ) throws Exception {
        instance = new DbConnection(url, username, password);
        initTriggered = true;
    }

    public static DbConnection getInstance() throws Exception {
        if (!initTriggered) {
            throw new Exception("Connection has not been initialised");
        }

        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DbConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    private DbConnection(
            final String url,
            final String username,
            final String password
    ) throws Exception {
        this.url = url;
        this.username = username;
        this.password = password;

        connection = DriverManager.getConnection(url, username, password);
    }

    private DbConnection() throws Exception {
        connection = DriverManager.getConnection(this.url, this.username, this.password);
    }
}
