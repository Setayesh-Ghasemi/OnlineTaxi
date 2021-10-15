package ir.maktab.dao;

import ir.maktab.model.vehicle.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDatabase {

    public static int addVehicle(Vehicle vehicle) throws SQLException {
        Connection connection = AccessToDB.getConnection();
        int generatedId = 0;
        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into vehicles (name, color, number) values (?,?,?)", 1);


            preparedStatement.setString(1, vehicle.getName());
            preparedStatement.setString(2, vehicle.getColor());
            preparedStatement.setString(3, vehicle.getNumber());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            generatedId = resultSet.getInt(1);
        } else {
            return 0;
        }
        return generatedId;
    }

    public static Vehicle getVehicleByDriverUsername(String driverUsername) throws SQLException {
        Connection connection = AccessToDB.getConnection();
        Vehicle vehicle = null;
        if (connection != null) {

            PreparedStatement statement = connection.prepareStatement("select * from vehicles where driverUsername = ?");
            statement.setString(1, driverUsername);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                vehicle = new Vehicle();
                vehicle.setName(resultSet.getString("name"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setNumber(resultSet.getString("number"));
            }
        }
        return vehicle;
    }

    public static Vehicle getVehicleById(int id) {
        Connection connection = AccessToDB.getConnection();
        Vehicle vehicle = new Vehicle();
        if (connection != null) {
            PreparedStatement statement = null;

            try {
                statement = connection.prepareStatement("select * from vehicles where vehicleId = ?");
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    vehicle.setName(resultSet.getString("name"));
                    vehicle.setNumber(resultSet.getString("number"));
                    vehicle.setColor(resultSet.getString("color"));
                    vehicle.setVehicleId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vehicle;
    }


}
