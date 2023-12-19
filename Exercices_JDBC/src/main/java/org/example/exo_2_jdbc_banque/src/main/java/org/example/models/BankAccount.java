package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
    private int idBankAccount;
    @NonNull
    private long soldAccount;
    @NonNull
    private Customer customer;
    @NonNull
    private List<Operations> operations;

    public BankAccount(int idBankAccount) {
        this.idBankAccount = idBankAccount;
    }

    public BankAccount(@NonNull Customer customer) {
        this.customer = customer;
    }

    public BankAccount(@NonNull long soldAccount, @NonNull Customer customer) {
        this.soldAccount = soldAccount;
        this.customer = customer;
    }
}
