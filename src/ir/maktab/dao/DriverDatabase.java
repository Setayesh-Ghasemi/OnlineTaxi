package ir.maktab.dao;

import ir.maktab.model.Driver;
import ir.maktab.model.vehicle.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverDatabase {

    public int addDriver(Driver driver) throws SQLException {
        Connection connection = AccessToDB.getConnection();

        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into drivers (driverUsername, name, family, nationalCode, phoneNumber, age, vehicleId) values ( ?, ?,?,?,?,?,?)");
            preparedStatement.setString(1, driver.getUsername());
            preparedStatement.setString(2, driver.getName());
            preparedStatement.setString(3, driver.getFamily());
            preparedStatement.setString(4, driver.getNationalCode());
            preparedStatement.setString(5, driver.getPhoneNumber());
            preparedStatement.setInt(6, driver.getAge());
            preparedStatement.setInt(7, driver.getVehicle().getVehicleId());

            int i = preparedStatement.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }

    public List<Driver> getAllDriver() throws SQLException {
        Connection connection = AccessToDB.getConnection();
        if (connection != null) {
            List<Driver> drivers = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM drivers";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            Driver driver = null;
            Vehicle vehicle = null;
            while (resultSet.next()) {
                driver = new Driver();
                driver.setUsername(resultSet.getString("driverUsername"));
                driver.setName(resultSet.getString("name"));
                driver.setFamily(resultSet.getString("family"));
                driver.setNationalCode(resultSet.getString("nationalId"));
                driver.setPhoneNumber(resultSet.getString("phoneNumber"));
                driver.setAge(resultSet.getInt("age"));
                int vehicleId = resultSet.getInt("vehicleId");
                vehicle = CarDatabase.getVehicleById(vehicleId);
                driver.setVehicle(vehicle);
                drivers.add(driver);
            }
            return drivers;
        } else {
            return Collections.emptyList();
        }
    }

    public Driver getDriverByDriverUserName(String driverUserName) throws SQLException {
        Connection connection = AccessToDB.getConnection();
        Driver driv = null;
        Vehicle vehicle = null;
        if (connection != null) {

            PreparedStatement statement = connection.prepareStatement("select * from drivers where driverUserName = ?");
            statement.setString(1, driverUserName);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                driv = new Driver();
                driv.setUsername(rs.getString("driverUsername"));
                driv.setName(rs.getString("name"));
                driv.setFamily(rs.getString("family"));
                driv.setNationalCode(rs.getString("nationalCode"));
                driv.setPhoneNumber(rs.getString("phoneNumber"));
                driv.setAge(rs.getInt("age"));
                int vehicleId = rs.getInt("vehicleId");
                vehicle = CarDatabase.getVehicleById(vehicleId);
                driv.setVehicle(vehicle);
                return driv;

            }
        }
        return null;
    }
}