package org.example.service;

import org.example.dao.BankAccountDaoImpl;
import org.example.dao.CustomerDaoImpl;
import org.example.dao.OperationDaoImpl;
import org.example.models.BankAccount;
import org.example.models.Customer;
import org.example.models.Operation;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankService implements IBankService {

    private BankAccountDaoImpl bankAccountDao;
    private CustomerDaoImpl customerDao;
    private OperationDaoImpl operationDao;
    private Connection connection;

    public BankService() {
        try {
            connection = new DatabaseManager().getConnection();
            bankAccountDao = new BankAccountDaoImpl(connection);
            customerDao = new CustomerDaoImpl(connection);
            operationDao = new OperationDaoImpl(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer createAndSaveCustomer(String firstName, String lastName, String phone) {
        Customer customer = new Customer(firstName, lastName, phone);
        try {
            if (customerDao.save(customer)) {
                return customer;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public BankAccount createAndSaveBankAccount(int idCustomer) {
        BankAccount bankAccount = new BankAccount(getCustomerById(idCustomer), 0);
        try {
            if (bankAccountDao.save(bankAccount)) {
                return bankAccount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<BankAccount> getAllAccountsByIdCustomer(int idCustomer) {
        try {
            return bankAccountDao.getByIdCustomer(idCustomer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        try {
            return customerDao.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try {
            return customerDao.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BankAccount getAccount(int id) {
        try {
            BankAccount bankAccount = bankAccountDao.get(id);
            if (bankAccount != null) {
                return bankAccount;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Operation> getAllOperationByAccountId(int id) {
        try {
            return operationDao.getOperationsByIdAccount(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean makeOperationDeposit(double montant, int idAccount) {
        Operation operation = new Operation(montant, idAccount);
        BankAccount bankAccount = getAccount(idAccount);
        try {
            return (bankAccount.makeDeposit(operation) && operationDao.save(operation) && bankAccountDao.update(bankAccount));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean makeOperationWithdrawal(double montant, int idAccount) {
        Operation operation = new Operation(montant, idAccount);
        BankAccount bankAccount = getAccount(idAccount);
        try {
            return (bankAccount.makeWithdrawal(operation) && operationDao.save(operation) && bankAccountDao.update(bankAccount));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
