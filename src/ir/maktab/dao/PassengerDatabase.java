package ir.maktab.dao;

import ir.maktab.model.Passenger;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PassengerDatabase {

    public int addPassenger(Passenger passenger) throws SQLException {
        Connection connection = AccessToDB.getConnection();

        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into passengers (PassengerUsername,name,family,nationalCode,phoneNumber,age,userStatus,balance) values (?, ?, ?, ?,? ,?,?,?)");
            preparedStatement.setString(1, passenger.getUsername());
            preparedStatement.setString(2, passenger.getName());
            preparedStatement.setString(3, passenger.getFamily());
            preparedStatement.setString(4, passenger.getNationalCode());
            preparedStatement.setString(5, passenger.getPhoneNumber());
            preparedStatement.setInt(6, passenger.getAge());
            preparedStatement.setString(7, passenger.getUserStatus().toString().toLowerCase());
            preparedStatement.setDouble(8, passenger.getBalance());
            int i = preparedStatement.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }

    public List<Passenger> getAllPassenger() throws SQLException {
        Connection connection = AccessToDB.getConnection();
        if (connection != null) {
            List<Passenger> passengers = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM passengers";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setUsername(resultSet.getString("passengerUserName"));
                passenger.setName(resultSet.getString("name"));
                passenger.setFamily(resultSet.getString("family"));
                passenger.setNationalCode(resultSet.getString("nationalCode"));
                passenger.setPhoneNumber(resultSet.getString("phoneNumber"));
                passenger.setAge(resultSet.getInt("age"));
                passenger.setBalance(resultSet.getDouble("accountBalance"));
                passengers.add(passenger);
            }
            return passengers;
        } else {
            return Collections.emptyList();
        }
    }

    public Passenger getPassengerByUserName(String username) throws SQLException {
        Connection connection = AccessToDB.getConnection();
        Passenger passenger = null;
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement("select * from passengers where PassengerUsername = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                passenger = new Passenger();
                passenger.setUsername(resultSet.getString("PassengerUsername"));
                passenger.setName(resultSet.getString("name"));
                passenger.setFamily(resultSet.getString("family"));
                passenger.setNationalCode(resultSet.getString("nationalCode"));
                passenger.setPhoneNumber(resultSet.getString("phoneNumber"));
                passenger.setAge(resultSet.getInt("age"));
                passenger.setBalance(resultSet.getDouble("accountBalance"));

            }
        }
        return passenger;
    }


    public int updatePassenger(String username, double balance) throws SQLException {
        Connection connection = AccessToDB.getConnection();
        if (connection != null) {
            String sql = "UPDATE passengers SET accountBalance = accountBalance + ?  WHERE passengerUsername = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setDouble(1, balance);
            preparedStmt.setString(2, username);
            int i = preparedStmt.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }

}
