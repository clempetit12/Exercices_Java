package org.example.models;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class BankAccount {

    private int id;
    private Customer customer;
    private double totalAmount;
    private List<Operation> operationList =new ArrayList<>() ;

    private int customerId;

    public BankAccount(Customer customer, double totalAmount) {
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.operationList = new ArrayList<>();
    }

    public BankAccount(int customerId) {
        this.customerId = customerId;
        this.operationList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public BankAccount(int id, int customerId, double totalAmount ) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
    }

    public boolean makeDeposit(Operation operation) {
        if (operation.getAmount() > 0) {
    operationList.add(operation);
    totalAmount += operation.getAmount();
    return  true;
        }
        return false;
    }

    public boolean makeWithdrawal(Operation operation) {
        if (operation.getAmount() < 0 && getTotalAmount() >= operation.getAmount()*-1) {
            operationList.add(operation);
            totalAmount += operation.getAmount();
            return  true;
        }
        return false;

    }

}
