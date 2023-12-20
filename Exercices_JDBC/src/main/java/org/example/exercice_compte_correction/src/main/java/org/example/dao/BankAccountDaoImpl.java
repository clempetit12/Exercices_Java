package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.models.BankAccount;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDaoImpl extends BaseDAO<BankAccount> {


    public BankAccountDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(BankAccount element) throws SQLException {
        request = "INSERT INTO accounts (customer_id ) VALUES (?) ";
        preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setDouble(1, element.getCustomer().getIdCustomer());
        int nbRows = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRows>0;
    }

    @Override
    public boolean update(BankAccount element) throws SQLException {
        request = "UPDATE  accounts SET solde  = ? WHERE account_id = ? ";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setDouble(1, element.getTotalAmount());
        preparedStatement.setInt(2,element.getId() );
        int nbRows = preparedStatement.executeUpdate();
        return nbRows>0;
    }

    @Override
    public boolean delete(BankAccount element) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Methode à implémenter !");
    }


    @Override
    public BankAccount get(int id) throws SQLException {
        BankAccount bankAccount = null;
        request = "SELECT * FROM accounts WHERE account_id = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
           bankAccount =new BankAccount(resultSet.getInt("account_id"),
                  resultSet.getInt("customer_id"),
                   resultSet.getDouble("solde"));
        }
        return bankAccount;
    }

    @Override
    public List<BankAccount> get() throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Methode à implémenter !");
    }


    public List<BankAccount> getByIdCustomer(int id) throws SQLException {
        List<BankAccount> bankAccounts = new ArrayList<>();
        request = "SELECT * FROM accounts WHERE customer_id = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1,id );
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            BankAccount bankAccount =new BankAccount(resultSet.getInt("account_id"),
                    resultSet.getInt("customer_id"),
                    resultSet.getDouble("solde"));
            bankAccounts.add(bankAccount);
        }
        return bankAccounts;
    }
}
