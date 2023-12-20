package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class BankAccount {
    private int idBankAccount;
    @NonNull
    private long soldAccount;
    @NonNull
    private int idCustomer;
    @NonNull
    private List<Operations> operations = new ArrayList<>();

    public BankAccount(int idBankAccount) {
        this.idBankAccount = idBankAccount;
    }

    public BankAccount(@NonNull long soldAccount, @NonNull int idCustomer) {
        this.soldAccount = soldAccount;
        this.idCustomer = idCustomer;
    }

    public void addOperations (Operations operations1) {
        operations.add(operations1);
    }


}
