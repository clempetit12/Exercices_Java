package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.models.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends BaseDAO<Customer> {
    public CustomerDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Customer element) throws SQLException {
        request = "INSERT INTO customers (first_name,last_name,telephone ) VALUES (?, ?, ?) ";
        preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, element.getFirstName());
        preparedStatement.setString(2, element.getLastName());
        preparedStatement.setString(3, element.getPhone());
        int nbRows = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
            element.setIdCustomer(resultSet.getInt(1));
        }
        return nbRows>0;
    }

    @Override
    public boolean update(Customer element) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Methode à implémenter !");
    }

    @Override
    public boolean delete(Customer element) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Methode à implémenter !");
    }

    @Override
    public Customer get(int id) throws SQLException {
        Customer customer = null;
        request = "SELECT * FROM customers WHERE customer_id = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            customer = new Customer(resultSet.getInt("customer_id"),resultSet.getString("first_name"),
                    resultSet.getString("last_name"), resultSet.getString("telephone"));
        }
        return customer;
    }

    @Override
    public List<Customer> get() throws SQLException {
        List<Customer> results = new ArrayList<>();
        request = "SELECT * FROM customers ";
        preparedStatement = _connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Customer customer = new Customer(resultSet.getString("first_name"),
                    resultSet.getString("last_name"), resultSet.getString("telephone"));
            results.add(customer);
        }
        return results;
    }
}
