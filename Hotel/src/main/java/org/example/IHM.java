package org.example;

import java.util.*;

public class IHM {


    //todo


    public static Scanner scanner = new Scanner(System.in);
 public static Hotel newHotel;

 public static void start () {
     System.out.println("Veuillez entrer le nom de l'hôtel : ");
     String nomHotel = scanner.nextLine();
     intialisationHotel(nomHotel);
     printMenu();
 }
    public static void intialisationHotel(String nomHotel) {

        List<Chambre> listChambre = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();
        List<Client> listClient = new ArrayList<>();
        Chambre chambre2 = new Chambre(Math.random(), StatutChambre.AVAILABLE, 50, 4);
        Chambre chambre3 = new Chambre(Math.random(), StatutChambre.AVAILABLE, 50, 3);
        Chambre chambre4 = new Chambre(Math.random(), StatutChambre.AVAILABLE, 50, 1);
        Chambre chambre5 = new Chambre(Math.random(), StatutChambre.AVAILABLE, 50, 5);
        ;
        Client client = new Client("Tara", "Dar", "0658595751");
        listClient.add(client);
        listChambre.add(chambre2);
        listChambre.add(chambre3);
        listChambre.add(chambre4);
        listChambre.add(chambre5);
        Comparator<Chambre> chambreComparator = Comparator.comparingInt(Chambre::getCapacity);
        Collections.sort(listChambre, chambreComparator);

        System.out.println(listChambre);



        newHotel = new Hotel(nomHotel,listChambre,reservations,listClient);

    }



    public static void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Ajouter un client ");
        System.out.println("2. Afficher la liste des clients");
        System.out.println("3. Afficher les réservations d'un client");
        System.out.println("4. Ajouter une réservation");
        System.out.println("5. Afficher la liste des réservations");
        System.out.println("0. Quitter");
        int choix;

        while (true) {
            printMenu();
            System.out.print("Sélectionnez votre choix : ");
            choix = scanner.nextInt();
            //     choix = parseInt(scanner.next()); autre maniere de recuperer choix

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
                case 5:
                    ;
                    break;
                case 0:
                    scanner.close();
                    break;


            }
            System.out.println();
        }

    }

    private static void addClient() {
        String firstname;
        String lastname;
        String phoneNumber;
        System.out.println("Veuillez indiquer le prénom : ");
        firstname = scanner.next();
        System.out.println("Veuillez indiquer le nom : ");
        lastname = scanner.next();
        System.out.println("Veuillez indiquer le numéro de téléphone : ");
        phoneNumber = scanner.next();
        newHotel.addClientToHotel(firstname,lastname,phoneNumber);

    }

    private static void getListClient() {
        System.out.println("La liste des clients est la suivante : " + listclient);
    }

    private static void getReservationClient() {
        String numeroTelephone;
        boolean reservationFound = true;
        System.out.println("Veuillez renseiner votre numéro de téléphone svp : ");
        numeroTelephone = scanner.next();

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

    private static void createChambre() {

    }

    private static void addReservation(){
            String numeroTelephone;
            int nombreoccupants;
            System.out.println("Veuillez renseiner votre numéro de téléphone svp : ");
            scanner.nextLine();
            numeroTelephone = scanner.nextLine();
            System.out.println(numeroTelephone);
            System.out.println("Veuillez renseigner le nombre d'occupants svp : ");
            try {
                nombreoccupants = Integer.parseInt(scanner.nextLine());
                System.out.println(nombreoccupants);
            } catch (NumberFormatException e) {
                System.out.println("Saisie invalide pour le nombre d'occupants.");
                return;
            }

            for (Client cl : clientList) {
                {
                    System.out.println(clientList);


                    if (numeroTelephone.equals(cl.getPhoneNumber())) {
                        Client foundclient = cl;
                        System.out.println(foundclient);
                        for (Chambre c : chambres) {
                            System.out.println(c);
                            if ((c.getStatutChambre() == StatutChambre.AVAILABLE) && (nombreoccupants <= c.getCapacity())) {
                                Reservation reservation = new Reservation(new Random().nextInt(1000), StatutReservation.VALIDE, foundclient, c);
                                reservation.getChambre().setStatutChambre(StatutChambre.NOAVAILABLE);
                                System.out.println(reservation);
                                reservations.add(reservation);
                                return;
                            }
                        }

                    }
                    System.out.println("Il n'y a pas de chambres libres");
                }


            }
        }
    }

