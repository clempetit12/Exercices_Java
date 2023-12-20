package org.example.dao;

import org.example.enums.OperationsEnum;
import org.example.models.BankAccount;
import org.example.models.Customer;
import org.example.models.Operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperationsDAO extends BaseDAO<Operations> {
    public OperationsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Operations element) throws SQLException {
        request = "INSERT INTO operations (account_id,montant,statut ) VALUES (?, ?, ?) ";
        preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, element.getBankAccountId());
        preparedStatement.setLong(2, element.getAmount());
        preparedStatement.setString(3, element.getOperationsEnum().name());
        int nbRows = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setIdOperation(resultSet.getInt(1));
        }
        return nbRows > 0;
    }

    @Override
    public boolean update(Operations element) throws SQLException {
        request = "UPDATE  operations SET account_id  = ? , montant = ?, statut = ? WHERE operation_id = ? ";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, element.getBankAccountId());
        preparedStatement.setLong(2, element.getAmount());
        preparedStatement.setObject(3, element.getOperationsEnum());
        int nbRows = preparedStatement.executeUpdate();
        return nbRows > 0;
    }

    @Override
    public boolean delete(Operations element) throws SQLException {
        request = "DELETE FROM operations WHERE operation_id = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, element.getIdOperation());
        int nbRows = preparedStatement.executeUpdate();
        return nbRows > 0;
    }

    @Override
    public Operations get(int id) throws SQLException {
        Operations operations = null;
        request = "SELECT * FROM operations WHERE operation_id = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String statutAsString = resultSet.getString("statut");
            OperationsEnum statutEnum = OperationsEnum.valueOf(statutAsString);

            operations = new Operations(resultSet.getInt("operation_id"), resultSet.getLong("montant"), statutEnum, resultSet.getInt("account_id"));
        }
        return operations;
    }


    @Override
    public List<Operations> get() throws SQLException {
        List<Operations> results = new ArrayList<>();
        request = "SELECT operation_id, account_id, montant, statut FROM operations";
        preparedStatement = _connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String statutAsString = resultSet.getString("statut");
            OperationsEnum statutEnum = OperationsEnum.valueOf(statutAsString);

            BankAccount bankAccount = new BankAccount(resultSet.getInt("account_id"));

            Operations operations = new Operations(resultSet.getInt("operation_id"), resultSet.getLong("montant"), statutEnum, resultSet.getInt("account_id"));
            results.add(operations);
        }

        return results;
    }

    public List<Operations> getOperationsForAccount(int accountId) throws SQLException {
        List<Operations> operations = new ArrayList<>();
        String request = "SELECT * FROM operations WHERE account_id = ?";
        preparedStatement = _connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        preparedStatement.setInt(1, accountId);
        while (resultSet.next()) {
            String statutAsString = resultSet.getString("statut");
            OperationsEnum statutEnum = OperationsEnum.valueOf(statutAsString);

            Operations operation = new Operations(
                    resultSet.getInt("operation_id"),
                    resultSet.getLong("montant"),
                    statutEnum,
                    resultSet.getInt("account_id")
            );
            operations.add(operation);
        }

        return operations;
    }

}
