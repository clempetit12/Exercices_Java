package org.example.exercice_1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getMySQLConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/exercice_jdbc_1";
        String userName = "root";
        String password = "2554";
        Connection connection = DriverManager.getConnection(url,userName,password);
        return connection;
    }
}
