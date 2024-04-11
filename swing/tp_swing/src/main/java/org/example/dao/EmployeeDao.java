package org.example.dao;

import org.example.model.Employee;
import org.example.utils.ConnexionDB;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private Connection connection;


    public EmployeeDao() {
        try {
            connection = ConnexionDB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addEmployee(Employee employee) {

        String query = "INSERT INTO employe (name,gender,age,bloodGroup,contactNumber,startDate,adress,urlImage) VALUES (?, ?, ?, ?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, String.valueOf(employee.isGender()));
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getBloodGroup());
            preparedStatement.setString(5, employee.getContactNumber());
            preparedStatement.setDate(6, Date.valueOf(employee.getStartDate()));
            preparedStatement.setString(7, employee.getAdress());
            preparedStatement.setString(8, employee.getUrlImage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return 0;
    }


    public int updateEmployee(Employee employee) {
        String query = "UPDATE employe SET name = ?, gender = ?, age = ? ,bloodGroup = ?, contactNumber = ?, startDate = ?, adress = ?, urlImage = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, String.valueOf(employee.isGender()));
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getBloodGroup());
            preparedStatement.setString(5, employee.getContactNumber());
            preparedStatement.setDate(6, Date.valueOf(employee.getStartDate()));
            preparedStatement.setString(7, employee.getAdress());
            preparedStatement.setString(8, employee.getUrlImage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return 0;
    }


public Employee searchEmployee(int id ) {

    String query = "SELECT * FROM employe WHERE id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            boolean gender = Boolean.parseBoolean(resultSet.getString("gender"));
            int age = resultSet.getInt("age");
            String bloodGroup = resultSet.getString("bloodGroup");
            String contactNumber = resultSet.getString("contactNumber");
            LocalDate startDate = resultSet.getDate("startDate").toLocalDate();
            String adress = resultSet.getString("adress");
            String urlImage = resultSet.getString("urlImage");
     Employee employee = new Employee(id,name,gender,age,bloodGroup,contactNumber,startDate,adress,urlImage);

            return employee;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;



}


    public void deleteEmployee(int id) {
        String query = "DELETE FROM employe WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> displayAll() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(resultSet.getBoolean("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setBloodGroup(resultSet.getString("bloodGroup"));
                employee.setContactNumber(resultSet.getString("contactNumber"));
                employee.setStartDate(resultSet.getDate("startDate").toLocalDate());
                employee.setAdress(resultSet.getString("adress"));
                employee.setUrlImage(resultSet.getString("urlImage"));
               employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }


}
