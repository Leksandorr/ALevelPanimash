package com.alevelhw.hw23.repository;

import com.alevelhw.module2.util.Util;
import com.alevelhw.hw23.util.UtilHW23;

import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class TablesFillRepository extends AbstractRepository {
    private final List<String> factoryNamesList = Arrays.asList(
            "Samsung", "LG", "Asus", "Xiaomi", "Apple", "Sony");
    private final List<String> countriesList = Arrays.asList(
            "Korea", "Taiwan", "China", "USA", "Japan");
    private final List<String> devicesList = Arrays.asList(
            "Television", "Smartphone", "Tablet", "Smartwatch", "Laptop");

    public void fillDatabase(int quantityFactories, int quantityDevices) {
        int counter = 0;
        while (counter < quantityFactories) {
            addRandomFactorySQL();
            counter++;
        }
        counter = 0;
        while (counter < quantityDevices) {
            addRandomDeviceSQL();
            counter++;
        }
    }

    private void addRandomFactorySQL() {
        String createFactorySQL = "INSERT INTO stock.public.factories (factory_name, country) VALUES (?, ?)";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(createFactorySQL)) {
            statement.setString(1, getRandomFactoryName());
            statement.setString(2, getRandomCountry());
            statement.execute(); //boolean???
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addRandomDeviceSQL() {
        String dummy = "Lorem ipsum dolor sit amet, consectetur adipiscing elit" +
                ", sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        String createDeviceSQL = "INSERT INTO stock.public.devices (" +
                "device_type, model, price, creation_date, description, is_available, factory_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(createDeviceSQL)) {
            statement.setString(1, getRandomDeviceType());
            statement.setString(2, getRandomModel());
            statement.setBigDecimal(3, BigDecimal.valueOf(Util.getRandomInt(150, 5000)));
            statement.setDate(4, getRandomDate());
            statement.setString(5, dummy);
            statement.setBoolean(6, getRandomBoolean());
            statement.setInt(7, getRandomFactoryId());
            statement.execute();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    private String getRandomFactoryName() {
        return factoryNamesList.get(Util.getRandomInt(0, factoryNamesList.size() - 1));
    }

    private String getRandomCountry() {
        return countriesList.get(Util.getRandomInt(0, countriesList.size() - 1));
    }

    private String getRandomDeviceType() {
        return devicesList.get(Util.getRandomInt(0, devicesList.size() - 1));
    }

    private String getRandomModel() {
        return UtilHW23.getRandomLatinString(1, 3).toUpperCase() + "-" +
                Util.getRandomInt(1, 99);
    }

    private Date getRandomDate() throws ParseException {
        String dateString = Util.getRandomInt(2017, 2021) +
                "-" +
                Util.getRandomInt(1, 12) +
                "-" +
                Util.getRandomInt(1, 28);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(dateString);
        return new Date(date.getTime());
    }

    private boolean getRandomBoolean() {
        return Util.getRandomInt(0, 1) == 1;
    }

    private int getRandomFactoryId() {
        int quantityFactories = 0;
        String quantityFactoriesSQL = "SELECT COUNT(factory_id) FROM stock.public.factories";
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(quantityFactoriesSQL)) {
            if (resultSet.next()) {
                quantityFactories = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Util.getRandomInt(1, quantityFactories);
    }
}
