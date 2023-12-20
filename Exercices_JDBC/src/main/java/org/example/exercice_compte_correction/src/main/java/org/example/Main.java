package org.example;

import org.example.service.BankService;
import org.example.utils.IHM;

public class Main {

    public static void main(String[] args) {
        new IHM(new BankService()).start();

    }
}