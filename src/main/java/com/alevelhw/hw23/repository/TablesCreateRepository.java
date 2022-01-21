package com.alevelhw.hw23.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesCreateRepository extends AbstractRepository {

    public void createTableSQL(String SQL) {
        try(Connection connection = createConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createFactoryTableSQL() {
        String factoryTableSQL = "CREATE TABLE factories " +
                "(factory_id serial PRIMARY KEY, " +
                " factory_name VARCHAR(50) NOT NULL, " +
                " country VARCHAR (50) NOT NULL)";
        createTableSQL(factoryTableSQL);
    }

    public void createDeviceTableSQL() {
        String deviceTableSQL = "CREATE TABLE devices " +
                "(device_id serial PRIMARY KEY, " +
                " device_type VARCHAR(50) NOT NULL, " +
                " model VARCHAR (50) NOT NULL, " +
                " price NUMERIC (10, 2), " +
                " creation_date DATE NOT NULL, " +
                " description VARCHAR, " +
                " is_available BOOLEAN NOT NULL, " +
                " factory_id INT, " +
                " CONSTRAINT factory_fk FOREIGN KEY(factory_id) REFERENCES factories(factory_id) " +
                " ON DELETE CASCADE)";
        createTableSQL(deviceTableSQL);
    }
}
