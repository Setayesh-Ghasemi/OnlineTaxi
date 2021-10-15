package ir.maktab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessToDB {
    public static Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi", "root", "root!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("not connected to DB");

        }
        return connection;
    }
}
