package org.example.service;

import org.example.models.BankAccount;
import org.example.models.Customer;
import org.example.models.Operation;

import java.util.List;

public interface IBankService {

public Customer createAndSaveCustomer(String firstName, String lastName, String phone);

public BankAccount createAndSaveBankAccount(int idCustomer);

public List<BankAccount> getAllAccountsByIdCustomer(int idCustomer);

public Customer getCustomerById(int id);

public List<Customer> getAllCustomers();

public BankAccount getAccount(int id);

public List<Operation> getAllOperationByAccountId (int id);

public boolean makeOperationDeposit(double montant, int idAccount);

public boolean makeOperationWithdrawal(double montant, int idAccount);



}
