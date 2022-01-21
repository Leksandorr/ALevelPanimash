package com.alevelhw.hw23.repository;

import com.alevelhw.hw23.entity.Device;
import com.alevelhw.hw23.entity.Factory;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ActionRepository extends AbstractRepository {

    public Device getDeviceById(long id) {
        String selectDeviceByIdSQL = "SELECT * FROM stock.public.devices WHERE device_id = ?";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(selectDeviceByIdSQL)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Device device = new Device();
                    device.setId(resultSet.getLong(1));
                    device.setType(resultSet.getString(2));
                    device.setModel(resultSet.getString(3));
                    device.setPrice(resultSet.getBigDecimal(4));
                    device.setDate(resultSet.getDate(5));
                    device.setDescription(resultSet.getString(6));
                    device.setAvailable(resultSet.getBoolean(7));
                    device.setFactoryId(resultSet.getLong(8));
                    return device;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Factory getFactoryById(long id) {
        String selectDeviceByIdSQL = "SELECT * FROM stock.public.factories WHERE factory_id = ?";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(selectDeviceByIdSQL)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Factory factory = new Factory();
                    factory.setId(resultSet.getLong(1));
                    factory.setName(resultSet.getString(2));
                    factory.setCountry(resultSet.getString(3));
                    return factory;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeDevise(Device device) {
        long id = device.getId();
        String selectDeviseByIdSQL = "SELECT * FROM stock.public.devices WHERE device_id = ?";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(
                     selectDeviseByIdSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    resultSet.updateLong("device_id", device.getId());
                    resultSet.updateString("device_type", device.getType());
                    resultSet.updateString("model", device.getModel());
                    resultSet.updateBigDecimal("price", device.getPrice());
                    resultSet.updateDate("creation_date", device.getDate());
                    resultSet.updateString("description", device.getDescription());
                    resultSet.updateBoolean("is_available", device.isAvailable());
                    resultSet.updateLong("factory_id", device.getFactoryId());
                    resultSet.updateRow();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDevice(Device device) {
        long id = device.getId();
        String deleteDeviseByIdSQL = "SELECT * FROM stock.public.devices WHERE device_id = ?";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(
                     deleteDeviseByIdSQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    resultSet.deleteRow();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Device> getDevisesByFactory(long factoryId) {
        List<Device> devices = new ArrayList<>();
        String getDevisesByFactorySQL = "SELECT d.* " +
                "FROM stock.public.devices d " +
                "INNER JOIN stock.public.factories f on d.factory_id = f.factory_id " +
                "WHERE f.factory_id = ?";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(getDevisesByFactorySQL)) {
            statement.setLong(1, factoryId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Device device = new Device();
                    device.setId(resultSet.getLong("device_id"));
                    device.setType(resultSet.getString("device_type"));
                    device.setModel(resultSet.getString("model"));
                    device.setPrice(resultSet.getBigDecimal("price"));
                    device.setDate(resultSet.getDate("creation_date"));
                    device.setDescription(resultSet.getString("description"));
                    device.setAvailable(resultSet.getBoolean("is_available"));
                    device.setFactoryId(resultSet.getLong("factory_id"));
                    devices.add(device);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return devices;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<Integer, Integer> getTotalQuantityDevicesForEachFactory() {
        String quantityDevicesForFactoriesSQL = "SELECT factory_id, COUNT(*) " +
                "FROM stock.public.devices " +
                "GROUP BY(factory_id) " +
                "ORDER BY factory_id";
        return getIntegerIntegerMapFromDatabase(quantityDevicesForFactoriesSQL);
    }

    public Map<Integer, Integer> getTotalCostDevicesForEachFactory() {
        String totalCostDevicesFromFactoriesSQL = "SELECT factory_id, SUM(price) " +
                "FROM stock.public.devices " +
                "GROUP BY(factory_id) " +
                "ORDER BY factory_id";
        return getIntegerIntegerMapFromDatabase(totalCostDevicesFromFactoriesSQL);
    }

    public Map<Integer, Integer> getIntegerIntegerMapFromDatabase(String SQL) {
        Map<Integer, Integer> quantityDevicesMap = new LinkedHashMap<>();
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                quantityDevicesMap.put(
                        resultSet.getInt(1),
                        resultSet.getInt(2));
            }
            return quantityDevicesMap;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}