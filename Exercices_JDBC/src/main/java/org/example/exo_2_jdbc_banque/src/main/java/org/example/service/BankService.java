package org.example.service;


import lombok.Data;
import org.example.dao.BankAccountDao;
import org.example.dao.CustomerDao;
import org.example.dao.OperationsDAO;
import org.example.enums.OperationsEnum;
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

    public boolean createBankAccount(int idCustomer, long solde) {
        try {
            BankAccount bankAccount = new BankAccount(solde,idCustomer);
            Customer customer = customerDao.get(idCustomer);
            customer.getBankAccountList().add(bankAccount);
            customerDao.update(customer);
            return bankAccountDao.save(bankAccount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean makeOperation(Operations operations) {
        try {

            operationsDAO.save(operations);

            BankAccount bankAccount = bankAccountDao.get(operations.getBankAccountId());
            bankAccount.addOperations(operations);
            if (operations.getOperationsEnum() == OperationsEnum.DEPOT) {

                bankAccount.setSoldAccount(bankAccount.getSoldAccount() + operations.getAmount());

            } else {

                if (bankAccount.getSoldAccount() - operations.getAmount() >= 0) {

                    bankAccount.setSoldAccount(bankAccount.getSoldAccount() - operations.getAmount());

                } else {

                    System.out.println("Il n'y a pas assez de fonds sur le compte !");
                    return false;
                }
            }


            bankAccountDao.update(bankAccount);

            System.out.println("Opération effectuée avec succès !");
            return true;

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
}
