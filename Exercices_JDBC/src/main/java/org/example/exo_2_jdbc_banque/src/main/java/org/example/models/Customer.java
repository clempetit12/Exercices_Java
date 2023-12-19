package org.example.models;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    private int idCustomer;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String telephoneNumber;

    private List<BankAccount> bankAccountList = new ArrayList<>();

    public Customer(@NonNull String firstName, @NonNull String lastName, @NonNull String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.bankAccountList = bankAccountList;
    }

    public void findCustomerbyId(int id) {

    }

    public BankAccount getBankAccountById(int bankAccount) {
        for (BankAccount ba : bankAccountList) {
            if (ba.getIdBankAccount() == bankAccount) {
                return ba;
            }
        }
        return null;
    }
}
