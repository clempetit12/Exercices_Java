package org.example.service;


import lombok.Data;
import org.example.dao.BankAccountDao;
import org.example.dao.CustomerDao;
import org.example.dao.OperationsDAO;
import org.example.models.BankAccount;
import org.example.models.Customer;
import org.example.models.Operations;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Data
public class BankService {

    private BankAccountDao bankAccountDao;
    private CustomerDao customerDao;
    private OperationsDAO operationsDAO;
    private Connection connection;

    public BankService() {
        try {
            connection = new DatabaseManager().getConnection();
            bankAccountDao = new BankAccountDao(connection);
            customerDao = new CustomerDao(connection);
            operationsDAO = new OperationsDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createCustomer(Customer customer) {
        try {
            return customerDao.save(customer);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean createBankAccount(Customer customer) {
        BankAccount bankAccount = new BankAccount(customer);
        try {

            if (bankAccountDao.save(bankAccount)) {
                customer.getBankAccountList().add(bankAccount);

                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean makeOperation(Operations operations) {
        try {

            return operationsDAO.save(operations);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public List<BankAccount> getAllAccounts () {
            try {
                return bankAccountDao.get();

            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    public Customer getCustomerbyid(int customerId) {
        try {
            return customerDao.get(customerId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Customer> getAllCustomers() {
        try {
            return customerDao.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
