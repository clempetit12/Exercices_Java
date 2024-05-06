package org.example.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String database = "work";
            String url = "jdbc:mysql://localhost:3306/";
            Connection con = DriverManager.getConnection(url + database, "root","25542554");
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
