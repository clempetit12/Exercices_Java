package ihm;

import dao.AccountDao;
import dao.AggencyDao;
import dao.CustomerDao;
import entity.Account;
import entity.Agency;
import entity.Customer;
import service.AccountService;
import service.AgencyService;
import service.CustomerService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IHM {

    private EntityManagerFactory emf;
    private Scanner scanner = new Scanner(System.in);
    private int choix;
    private static AgencyService agencyService;
    private static AccountService accountService;
    private static CustomerService customerService;
    private static AggencyDao aggencyDao;
    private static AccountDao accountDao;
    private static CustomerDao customerDao;

    public IHM() {
        emf = Persistence.createEntityManagerFactory("bank_bdd");

        aggencyDao = new AggencyDao(emf);
        agencyService = new AgencyService(aggencyDao);
        accountDao = new AccountDao(emf);
        accountService = new AccountService(accountDao);
        customerDao = new CustomerDao(emf);
        customerService = new CustomerService(customerDao);


    }

    public void start() {
        do {
            printMenu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    createAgency();
                    break;
                case 2:
                    createCustomer();
                    break;
                case 3:
                    createAccount();
                    break;
                case 4:
                    linkAccountToCustomer();
                    break;
                case 5:
                    displayAllAccounts();
                    break;
                case 0:
                    closeAll();
                    break;
                default:
                    System.out.println("choix invalide !");
            }

        } while (choix != 0);
    }

    private void displayAllAccounts() {
        System.out.println("Quel est l'id du client :");
        Long customerId = scanner.nextLong();
        Customer customer = customerService.findCustomer(customerId);
        for (Account a: customer.getAccountList()) {
            System.out.println(a);
        }

    }

    private void linkAccountToCustomer() {
        System.out.println("Quel est l'id du compte :");
        Long accountId = scanner.nextLong();
        Account account = accountService.findAccount(accountId);
        if (account != null) {
            System.out.println("Quel est l'id du client :");
            Long customerId = scanner.nextLong();
            Customer customer = customerService.findCustomer(customerId);
            if (customer != null) {
                account.getCustomerList().add(customer);
                accountService.addCustomerToAccount(customerId,accountId);
            }


        }

    }


    public void createAgency() {
        System.out.println("Quel nom souhaitez vous donner à votre agence :");
        String name = scanner.nextLine();
        System.out.println("Quel est l'adresse de cette agence ?:");
        String adress = scanner.nextLine();
        Agency agency = new Agency();
        agency.setAdress(adress);
        agencyService.createAgency(agency);
    }

    public void createCustomer() {
        try {
            System.out.println("Quel est votre nom :");
            String lastName = scanner.next();
            System.out.println("Quel est votre prenom :");
            String firstName = scanner.next();
            System.out.println("Quel est votre date de naissance (format dd-MM-yyyy)");
            String date_string = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(date_string);
            Customer customer = new Customer(lastName,firstName,date);
            customerService.createCustomer(customer);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void createAccount() {

        System.out.println("A quelle agence souhaitez vous rattacher ce compte :");
        Long id = scanner.nextLong();
       Agency agency = agencyService.findAgency(id);
        System.out.println("A quel client souhaitez vous attacher ce compte  :");
        Long customerId = scanner.nextLong();
        System.out.println("Quel est le libelle :");
        String libelle = scanner.next();
        System.out.println("Quel est l'iban (longeur max 27");
        String iban = scanner.next();
        Account account = new Account(libelle,iban,agency);
       accountService.createAccount(account,customerId,id);


    }

    private void closeAll() {
        agencyService.close();
        accountService.close();
        customerService.close();

    }


    private void printMenu() {
        System.out.println("=== ToDo ===");
        System.out.println("1. Création d'une banque");
        System.out.println("2. Création d'un client");
        System.out.println("3. Création d'un compte");
        System.out.println("4. Rattacher un compte existant à un client");
        System.out.println("5. Afficher tous les comptes existants d'un client");
        System.out.println("0. Quitter");
        System.out.println("Saisissez votre choix :");

    }
}
