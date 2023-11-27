package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHM {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Client> clients = new ArrayList<>();
    public static List<Reservation> reservations = new ArrayList<>();
    public static List<Chambre> chambres = new ArrayList<>();

    public static void main(String[] args) {
        String nomHotel;
        Hotel newHotel;
        int choix;


        Chambre[] listchambre = new Chambre[20];
        createChambre();
        System.out.println("Veuillez entrer le nom de l'hôtel : ");
        nomHotel = scanner.nextLine();

        newHotel = new Hotel(nomHotel, listchambre);
        while (true) {
            printMenu();
            System.out.print("Sélectionnez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    addClient();
                    break;
                case 2:
                    getListClient();
                    break;
                case 3:
                    getReservationClient();
                    break;
                case 4:
                    addReservation();
                    break;


            }
            System.out.println();
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
        String phoneNumber;
        System.out.println("Veuillez indiquer le prénom : ");
        firstname = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Veuillez indiquer le nom : ");
        lastname = scanner.nextLine();
        System.out.println("Veuillez indiquer le numéro de téléphone : ");
        phoneNumber = scanner.nextLine();




        Client client = new Client(firstname, lastname, phoneNumber);

        clients.add(client);


    }

    private static void getListClient() {
        System.out.println("La liste des clients est la suivante : " + clients);
    }

    private static void getReservationClient() {
        String numeroTelephone;
        boolean reservationFound = false;
        System.out.println("Veuillez renseiner votre numéro de téléphone svp : ");
        numeroTelephone = scanner.nextLine();
        for (Reservation res : reservations) {
            if (numeroTelephone.equals(res.getClient().getPhoneNumber())) {
                System.out.println(res);
                reservationFound = true;
            }

        }
        if (!reservationFound) {
            System.out.println("Il n'y a pas de réservation.");
        }


    }

    private static void createChambre () {
        Chambre chambre = new Chambre(Math.random(),StatutChambre.AVAILABLE,50,2 );
        Chambre chambre2 = new Chambre(Math.random(),StatutChambre.AVAILABLE,50,4 );
        Chambre chambre3 = new Chambre(Math.random(),StatutChambre.AVAILABLE,50,3 );
        Chambre chambre4 = new Chambre(Math.random(),StatutChambre.AVAILABLE,50,1 );
        Chambre chambre5 = new Chambre(Math.random(),StatutChambre.AVAILABLE,50,5 );
    }
    private static void addReservation() {
        String numeroTelephone;
        int nombreoccupants;
        System.out.println("Veuillez renseiner votre numéro de téléphone svp : ");
        numeroTelephone = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Veuillez renseiner le nombre d'occupants svp : ");
        nombreoccupants = scanner.nextInt();

        for (Client cl : clients) {
            {
                if (numeroTelephone.equals(cl.getPhoneNumber())) {
                    Client foundclient = cl;
                    for (Chambre c : chambres) {
                        if ((c.getStatutChambre() == StatutChambre.AVAILABLE)  && (nombreoccupants <= c.getCapacity())) {

                            Reservation reservation = new Reservation(Math.random(), StatutReservation.VALIDE, foundclient, c);
                            System.out.println(reservation);
                            return;
                        }
                    }

                }
                System.out.println("Il n'y a pas de chambres libres");
            }


        }

    }
}
