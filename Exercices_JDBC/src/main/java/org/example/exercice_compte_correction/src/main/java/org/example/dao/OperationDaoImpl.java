package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.models.BankAccount;
import org.example.models.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperationDaoImpl extends BaseDAO<Operation> {
    public OperationDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Operation element) throws SQLException {
        request = "INSERT INTO operations (account_id,montant,statut ) VALUES (?, ?, ?) ";
        preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, element.getAccountId());
        preparedStatement.setDouble(2, element.getAmount());
        // ordinal ppur un enum pour avoir un int qui prend moins de place
        preparedStatement.setInt(3, element.getOperationStatus().ordinal());
        int nbRows = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRows > 0;
    }

    @Override
    public boolean update(Operation element) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Methode à implémenter !");
    }

    @Override
    public boolean delete(Operation element) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Methode à implémenter !");
    }

    @Override
    public Operation get(int id) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Methode à implémenter !");
    }

    @Override
    public List<Operation> get() throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Methode à implémenter !");
    }

    public List<Operation> getOperationsByIdAccount (int id) throws SQLException {
        List<Operation> operations = new ArrayList<>();
        request = "SELECT * FROM operations WHERE operation_id = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1,id );
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Operation operation =new Operation(resultSet.getInt("operation_id"),
                    resultSet.getInt("account_id"),resultSet.getDouble("montant"));
            operations.add(operation);
        }
        return operations;
    }
}
