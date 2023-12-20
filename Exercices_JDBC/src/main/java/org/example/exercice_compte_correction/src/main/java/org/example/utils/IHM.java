package org.example.utils;

import org.example.models.BankAccount;
import org.example.models.Customer;
import org.example.models.Operation;
import org.example.service.IBankService;

import java.util.Scanner;

public class IHM {
    private Scanner scanner = new Scanner(System.in);
    private int choix;

    private IBankService _bankService;

    public IHM(IBankService bankService) {
        _bankService = bankService;
    }

    public void start() {
        do {
            printMenu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    createCustomerAndAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdrawal();
                    break;
                case 4:
                    displayAccount();
                    break;
                case 5:
                    displayAllBankAccountCustomer();
                    break;
                case 6:
                    addAccountToCustomer();
                    break;
                case 7:
                    createACustomer();
                    break;
                case 0:
                    scanner.close();
                    break;
                default:
                    System.out.println("choix invalide !");
            }

        } while (choix != 0);
    }

    private void deposit() {
        System.out.println("Merci de préciser l'id du compte bancaire");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de préciser le montant à déposer");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        if (_bankService.makeOperationDeposit(amount, id)) {
            System.out.println("dépot réussi");
        } else {
            System.out.println("erreur");
        }

    }

    private void withdrawal() {
        System.out.println("Merci de préciser l'id du compte bancaire");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de préciser le montant à retirer");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        if (_bankService.makeOperationWithdrawal(amount*-1, id)) {
            System.out.println("retrait réussi");
        } else {
            System.out.println("erreur");
        }
    }

    private void displayAccount() {
        System.out.println("Merci de préciser l'id du compte bancaire");
        int id = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = _bankService.getAccount(id);
        if(bankAccount != null) {
            for (Operation op: _bankService.getAllOperationByAccountId(bankAccount.getId())
                 ) {
                System.out.println(op);

            }
            System.out.println("solde actuelle du compte :" + bankAccount.getTotalAmount());
        }
    }

    private void displayAllBankAccountCustomer() {
        System.out.println("Merci de préciser l'id du client");
        int id = scanner.nextInt();
        scanner.nextLine();
        _bankService.getAllAccountsByIdCustomer(id).forEach(e -> System.out.println(e));
    }

    private void addAccountToCustomer() {
        System.out.println("Merci de préciser l'id du client");
        int id = scanner.nextInt();
        scanner.nextLine();
        Customer customer = _bankService.getCustomerById(id);
        if(customer != null) {
            BankAccount bankAccount = _bankService.createAndSaveBankAccount(customer.getIdCustomer());
            if(bankAccount != null) {
                System.out.println("Un compte supplémentaire a bien été ajouté , l'id du compte :"
                        + bankAccount.getId() + " pour le client " + customer.getLastName());
            }
        }
    }

    private int createACustomer() {
        System.out.println("Merci de saisir un prénom");
        String firstname = scanner.nextLine();
        System.out.println("Merci de saisir un nom");
        String lastName = scanner.nextLine();
        System.out.println("Merci de saisir un numéro de téléphone");
        String telephone = scanner.nextLine();
        Customer customer = _bankService.createAndSaveCustomer(firstname, lastName, telephone);
        return customer.getIdCustomer();

    }

    private void createCustomerAndAccount() {
        int idClient = createACustomer();
      BankAccount bankAccount=  _bankService.createAndSaveBankAccount(idClient);
        System.out.println("Compte créé avec id : " + bankAccount.getId());

    }

    private void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Création de client et compte");
        System.out.println("2. Réaliser un dépôt");
        System.out.println("3. Réaliser un retrait");
        System.out.println("4. Afficher compte");
        System.out.println("5. Affichage de tous les comptes d'un client");
        System.out.println("6. Ajouter un compte à un client");
        System.out.println("7. Création d'un client ");
        System.out.println("0. Quitter");
        System.out.println("Saisissez votre choix :");

    }
}
