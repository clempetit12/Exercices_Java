package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHM {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String nomHotel;
        Hotel newHotel;
        int choix;




        Chambre[] listchambre = new Chambre[20];
        System.out.println("Veuillez entrer le nom de l'hôtel : ");
        nomHotel = scanner.nextLine();

        newHotel = new Hotel(nomHotel, listchambre);
        printMenu();
        System.out.print("Sélectionnez votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1 :
                addClient();
                break;
            case 2:



        }


    }

    private static void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Ajouter un client ");
        System.out.println("2. Afficher la liste des clients");
        System.out.println("3. Afficher les réservations d'un client");
        System.out.println("4. Ajouter une réservation");
        System.out.println("4. Afficher la liste des réservations");


    }
    private static void addClient() {
        String firstname;
        String lastname;
        int phoneNumber;
        System.out.println("Veuillez indiquer le prénom : ");
        firstname = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Veuillez indiquer le nom : ");
        lastname = scanner.nextLine();
        System.out.println("Veuillez indiquer le numéro de téléphone : ");
        phoneNumber = scanner.nextInt();

        Client client = new Client(firstname,lastname,phoneNumber);
        List<Client> clients = new ArrayList<>();
        clients.add(client);
        System.out.println("Liste des clients : " + clients);





    }

    private static void getChoice() {

    }
}
