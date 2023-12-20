package org.example.models;

import lombok.Builder;
import lombok.Data;


public class Operation {

    private int id;
    private double amount;
    private OperationEnum operationStatus ;
    private int accountId;

    public Operation(double amount, int accountId) {
        this.amount = amount;
        this.accountId = accountId;
        this.operationStatus = (this.amount > 0 ) ? OperationEnum.DEPOSIT : OperationEnum.WITHDRAWAL;
    }

    public Operation(int id,int accountId, double amount ) {
        this(amount, accountId);
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OperationEnum getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(OperationEnum operationStatus) {
        this.operationStatus = operationStatus;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
