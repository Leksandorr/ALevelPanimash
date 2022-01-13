package com.alevelhw.hw23.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractRepository {
    public Connection createConnection() throws SQLException {
        return  DriverManager.getConnection("jdbc:postgresql://localhost:5432/stock", "postgres", "root");
    }
}
