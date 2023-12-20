package org.example.dao;

import lombok.Data;
import org.example.models.BankAccount;
import org.example.models.Customer;
import org.example.models.Operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BankAccountDao extends BaseDAO<BankAccount> {

    public BankAccountDao(Connection connection) {
        super(connection);
    }



    @Override
    public boolean save(BankAccount element) throws SQLException {
        request = "INSERT INTO accounts (solde,customer_id ) VALUES (?, ?) ";
        preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setLong(1, element.getSoldAccount());
        preparedStatement.setInt(2,element.getIdCustomer() );
        int nbRows = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
            element.setIdBankAccount(resultSet.getInt(1));
        }
        return nbRows>0;

    }

    @Override
    public boolean update(BankAccount element) throws SQLException {
        request = "UPDATE  accounts SET solde  = ? , customer_id = ? WHERE account_id = ? ";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setLong(1, element.getSoldAccount());
        preparedStatement.setInt(2,element.getIdCustomer() );
        preparedStatement.setInt(3,element.getIdBankAccount() );
        int nbRows = preparedStatement.executeUpdate();
        return nbRows>0;

    }

    @Override
    public boolean delete(BankAccount element) throws SQLException {
        request = "DELETE FROM accounts WHERE id = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, element.getIdBankAccount());
        int nbRows = preparedStatement.executeUpdate();
        return nbRows>0;
    }

    @Override
    public BankAccount get(int id) throws SQLException {
        BankAccount bankAccount = null;
        request = "SELECT * FROM accounts WHERE account_id = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            int account_id = resultSet.getInt("account_id");
            long solde = resultSet.getLong("solde");
            int customer_id = resultSet.getInt("customer_id");

            List<Operations> operations = Operations.getOperationsForAccount(account_id);
            bankAccount = new BankAccount(account_id, solde, customer_id, operations);
        }
        return bankAccount;
    }

    @Override
    public List<BankAccount> get() throws SQLException {
        List<BankAccount> results = new ArrayList<>();
        request = "SELECT * FROM accounts ";
        preparedStatement = _connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){

            int account_id = resultSet.getInt("account_id");
            long solde = resultSet.getLong("solde");
            int customer_id = resultSet.getInt("customer_id");


            List<Operations> operations = Operations.getOperationsForAccount(account_id);
            BankAccount bankAccount = new BankAccount(account_id, solde, customer_id, operations);
            results.add(bankAccount);
        }
        return results;
    }
}
