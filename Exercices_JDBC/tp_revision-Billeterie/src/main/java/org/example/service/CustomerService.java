package org.example.service;

import org.example.dao.CustomerDao;
import org.example.dao.EventDao;
import org.example.dao.LocationDao;
import org.example.models.Customer;
import org.example.models.Event;
import org.example.models.Location;
import org.example.models.Tickets;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

public class CustomerService {

    private CustomerDao customerDao;
    private EventDao eventDao;
    private Connection connection;

    public CustomerService() {

        try{
            connection = new DatabaseManager().getConnection();
            eventDao = new EventDao(connection);
            customerDao = new CustomerDao(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer createAndSaveCustomer(String firstName, String lastName, String email) {
        Customer customer = new Customer(firstName,lastName,email);
        try {
            if (customerDao.save(customer)) {
                System.out.println("Un client a bien été créé avec id : " + customer.getId() );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }

    public Customer updateCustomer(Customer customer) {
        try {
            customerDao.update(customer);
            return customer ;

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCustomer(int id) {
        try {
            Customer customer = customerDao.get(id);
            if (customer != null) {
                customerDao.delete(customer);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    public Customer getCustomerById(int id) {
        try {
            return customerDao.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
