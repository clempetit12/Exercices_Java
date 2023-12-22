package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.models.Customer;
import org.example.models.Event;
import org.example.models.Location;
import org.example.models.Tickets;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends BaseDao<Customer> {
    public CustomerDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Customer element) throws SQLException {
        request = "INSERT INTO customers (first_name,last_name,email ) VALUES (?, ?, ?) ";
        preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, element.getfirstName());
        preparedStatement.setString(2, element.getlastName());
        preparedStatement.setString(3, element.getEmail());
        int nbRows = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRows>0;
    }

    @Override
    public boolean update(Customer element) throws SQLException {
        request = "UPDATE  customers SET first_name  = ? , last_name = ?, email = ? WHERE id_customer = ? ";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setString(1, element.getfirstName());
        preparedStatement.setString(2, element.getlastName());
        preparedStatement.setString(3, element.getEmail());
        preparedStatement.setInt(4, element.getId());
        int nbRows = preparedStatement.executeUpdate();
        return nbRows>0;
    }

    @Override
    public boolean delete(Customer element) throws SQLException {
        request = "DELETE FROM customers WHERE id_customer = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, element.getId());
        int nbRows = preparedStatement.executeUpdate();
        return nbRows>0;
    }

    @Override
    public Customer get(int id) throws SQLException {
        Customer customer = null;
        request = "SELECT * FROM customers WHERE id_customer = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            customer = new Customer(resultSet.getInt("id_customer"), resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email")
                    );
        }
        return customer;
    }

    @Override
    public List<Customer> get() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        request = "SELECT * FROM customers ";
        preparedStatement = _connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Customer  customer = new Customer(resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email")
            );
            customerList.add(customer);
        }
        return customerList;
    }


}
