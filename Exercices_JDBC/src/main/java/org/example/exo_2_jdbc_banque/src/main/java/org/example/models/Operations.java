package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.enums.OperationsEnum;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Operations {
    private int idOperation;
    @NonNull
    private long amount;
    @NonNull
    private OperationsEnum operationsEnum;
    @NonNull
    private int bankAccountId;

    public Operations( @NonNull int bankAccountId,@NonNull long amount, @NonNull OperationsEnum operationsEnum) {
        this.amount = amount;
        this.operationsEnum = operationsEnum;
        this.bankAccountId = bankAccountId;
    }

    public static List<Operations> getOperationsForAccount(int accountId) throws SQLException {
        List<Operations> operations = new ArrayList<>();
        return operations;
    }

}
