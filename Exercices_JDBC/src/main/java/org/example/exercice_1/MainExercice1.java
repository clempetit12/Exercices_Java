package org.example.exercice_1;

import org.example.exercice_1.service.IHM;
import org.example.exercice_1.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class MainExercice1 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = ConnectionUtils.getMySQLConnection();
            IHM.start();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
    }

    }

}
