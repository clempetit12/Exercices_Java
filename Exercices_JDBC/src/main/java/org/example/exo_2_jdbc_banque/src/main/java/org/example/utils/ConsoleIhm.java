package org.example.utils;

import org.example.dao.BankAccountDao;
import org.example.dao.CustomerDao;
import org.example.enums.OperationsEnum;
import org.example.models.BankAccount;
import org.example.models.Customer;
import org.example.models.Operations;
import org.example.service.BankService;

import java.util.Scanner;

public class ConsoleIhm {

    private Scanner scanner;
    private BankService bankService = new BankService();

    public ConsoleIhm() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choix;
        do {
            printMenu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    withdrawIhm();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    displayAccount();
                    break;
                case 5:
                    createBankAccount();
                    break;
                case 6:
                    scanner.close();
                    break;

            }
        } while (choix != 0);

    }

    private void createBankAccount() {


    }

    private void displayAccount() {
        bankService.getAllAccounts().forEach(e -> System.out.println(e));

    }

    private void deposit() {
        System.out.println("Merci de préciser l'id du client");
        int idCustomer = scanner.nextInt();
        System.out.println("Merci de préciser le montant à déposer");
        long amount = scanner.nextInt();
        System.out.println("Merci de préciser l'id du compte bancaire");
        int id = scanner.nextInt();
        Customer customer = bankService.getCustomerbyid(idCustomer);
        Operations deposit = new Operations(id, amount, OperationsEnum.DEPOT);
        bankService.makeOperation(deposit);


    }

    private void withdrawIhm() {
        System.out.println("Merci de préciser le montant à retirer");
        long amount = scanner.nextInt();
        System.out.println("Merci de préciser l'id du compte bancaire");
        int id = scanner.nextInt();
        Operations deposit = new Operations(id, amount, OperationsEnum.RETRAIT);
        if (bankService.makeOperation(deposit)) {
            System.out.println("Le dépot à bien été effectué!");

        } else {
            System.out.println("le dépot n'a pas pu se faire");
        }
        ;
    }

    private void createCustomer() {
        System.out.println("Merci de saisir un prénom");
        String firstname = scanner.nextLine();
        System.out.println("Merci de saisir un nom");
        String lastName = scanner.nextLine();
        System.out.println("Merci de saisir un numéro de téléphone");
        String telephone = scanner.nextLine();

        Customer customer = new Customer(firstname, lastName, telephone);
        if (bankService.createCustomer(customer)) {
            System.out.println("Une personne a été créée avec succès !");
            System.out.println("Merci de saisir le solde de départ ");
            long solde = scanner.nextInt();
            if (bankService.createBankAccount( customer.getIdCustomer(), solde) ){
                System.out.println("Le compte bancaire a été créé avec succès!");
            } else {
                System.out.println("La création du compte bancaire a échoué.");
            }
        } else {
            System.out.println("La création du client a échoué.");
        }

    }

    private void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Création de client et compte");
        System.out.println("2. Réaliser un retrait");
        System.out.println("3. Réaliser un dépôt");
        System.out.println("4. Afficher compte");
        System.out.println("5. Quitter");
        System.out.println("Saisissez votre choix :");
    }


}
