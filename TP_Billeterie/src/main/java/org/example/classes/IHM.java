package org.example.classes;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IHM {

    public static Scanner scanner = new Scanner(System.in);


    public static void start() {


        printMenu();

    }

    public static void printMenu() {

        int choix;

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Gérer les lieux ");
            System.out.println("2. Gérer les évènements ");
            System.out.println("3. Gérer les clients ");
            System.out.println("4. Acheter billets pour un évènement");
            System.out.println("5. Annuler un achat billet");
            System.out.println("6. Afficher la liste des évènements disponibles");
            System.out.println("7. Afficher la liste des billets achetés par un client");
            System.out.println("0. Quitter");
            System.out.println();
            System.out.print("Sélectionnez votre choix : ");
            choix = Integer.parseInt(scanner.nextLine());


            switch (choix) {
                case 1:
                    manageLocation();
                    break;
                case 2:
                    manageEvents();
                    break;
                case 3:
                    manageCustomer();
                    break;
                case 4:
                    buyTicketsForEvent();
                    break;
                case 5:
                    cancelTicketForEvent();
                    break;
                case 6:
                    displayAvailableEvent();
                    break;
                case 7:
                    displayTicketsBoughtByClient();
                    break;
                case 0:
                    scanner.close();
                    break;


            }
            System.out.println();
        }

    }
    //Gestion des lieux
    public static void manageLocation() {
        int choix2;
        while (true) {
            System.out.println("=== Gérer les lieux ===");
            System.out.println("1. Ajouter un lieu ");
            System.out.println("2. Modifier un lieu");
            System.out.println("3. Supprimer des lieux ");
            System.out.println("4. Retourner menu principal ");
            System.out.print("Sélectionnez votre choix : ");
           choix2 = Integer.parseInt(scanner.nextLine());

            switch (choix2) {
                case 1:
                    addLocation();
                    break;
                case 2:
                    editLocation();
                    break;
                case 3:
                    removeLocation();
                    break;
                case 4:
                    printMenu();
                    break;
            }
        }
    }

    public static void addLocation() {
        try{
            String name;
            String address;
            long capacity;
            System.out.println("Veuillez saisir le nom du lieu : ");
            name = scanner.next();
            scanner.nextLine();

            System.out.println("Veuillez saisir l'adresse' du lieu : ");
            address = scanner.nextLine();

            System.out.println("Veuillez saisir la capacité maximale du lieu : ");
            capacity = Integer.parseInt(scanner.nextLine());
            Location newLocation = new Location(name, address, capacity);
            System.out.println(newLocation);
            System.out.println();
            Location.getLocation(name);
            System.out.println("Nombre de lieux "+ Location.nbLocation());
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
    }}
    public static void editLocation() {
        try{
            String name;
            String newAddress;
            long newCapacity;
            System.out.println("Veuillez saisir le nom de la location à modifier : ");
            name= scanner.next();
            System.out.println("Veuillez saisir la nouvelle adresse' du lieu : ");
            newAddress = scanner.nextLine();
            System.out.println("Veuillez saisir la nouvelle capacité maximale du lieu : ");
            newCapacity = Integer.parseInt(scanner.nextLine());
            Location.modifyLocation(name,newAddress,newCapacity);
            Location.displayAllLocations();
        }catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void removeLocation() {
        String name;
        System.out.println("Veuillez saisir le nom du lieu à supprimer : ");
        name = scanner.nextLine();
        Location.deleteLocation(name);
        Location.displayAllLocations();
    }

    //Gestion des Evenements
    public static void manageEvents() {
        int choix3;
        while (true) {
            System.out.println("=== Gérer les Evenements ===");
            System.out.println("1. Ajouter un Evenement ");
            System.out.println("2. Modifier un Evenement");
            System.out.println("3. Supprimer un Evenement ");
            System.out.println("4. Retourner menu principal ");
            System.out.print("Sélectionnez votre choix : ");
            choix3 = Integer.parseInt(scanner.nextLine());

            switch (choix3) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    editEvent();
                    break;
                case 3:
                    removeEvent();
                    break;
                case 4:
                    printMenu();
                    break;
            }
        }
    }
    public static void addEvent() {
        try{
            String nameEvent;
            LocalDate date;
            LocalTime hour;
            String locationName;
            int numberOfTicketsSold;
            int price;
            System.out.println("Veuillez saisir le nom de l'évènement : ");
            nameEvent = scanner.next();
            scanner.nextLine();
            System.out.println("Veuillez saisir la date de l'évènement (au format yyyy-MM-dd) : ");
            String dateInput = scanner.nextLine();
            date = LocalDate.parse(dateInput, DateTimeFormatter.BASIC_ISO_DATE.ofPattern("yyyy-MM-dd"));
            System.out.println("Veuillez saisir l'heure de l'évènement (au format HH:mm) : ");
            String hourInput = scanner.nextLine();
            hour = LocalTime.parse(hourInput, DateTimeFormatter.ofPattern("HH:mm"));
            System.out.println("Veuillez saisir le lieu de l'évènement : ");
            locationName = scanner.next();
            scanner.nextLine();
            System.out.println("Veuillez saisir le prix de l'évènement : ");
            price = Integer.parseInt(scanner.nextLine());
            System.out.println("Veuillez saisir le nombre de places de l'évènement vendues : ");
            numberOfTicketsSold = Integer.parseInt(scanner.nextLine());
            Event newEvent = new Event(nameEvent,date,hour,locationName,price,numberOfTicketsSold);
            System.out.println(newEvent);
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void editEvent() {
        try{
            String nameEvent;
            LocalDate date;
            LocalTime hour;
            String locationName;
            int numberOfTicketsSold;
            int price;
            System.out.println("Veuillez saisir le nom de l'évènement à modifier : ");
            nameEvent= scanner.next();
            System.out.println("Veuillez saisir la nouvelle date de l'évènement (au format yyyy-MM-dd) : ");
            String dateInput = scanner.nextLine();
            date = LocalDate.parse(dateInput, DateTimeFormatter.BASIC_ISO_DATE.ofPattern("yyyy-MM-dd"));
            System.out.println("Veuillez saisir la nouvelle heure de l'évènement (au format HH:mm) : ");
            String hourInput = scanner.nextLine();
            hour = LocalTime.parse(hourInput, DateTimeFormatter.ofPattern("HH:mm"));
            System.out.println("Veuillez saisir le nouveau lieu de l'évènement : ");
            locationName = scanner.next();
            scanner.nextLine();
            System.out.println("Veuillez saisir le nouveau prix de l'évènement : ");
            price = Integer.parseInt(scanner.nextLine());
            System.out.println("Veuillez saisir le nombre de places de l'évènement vendues : ");
            numberOfTicketsSold = Integer.parseInt(scanner.nextLine());
            Event.modifyEvent(nameEvent,date,hour,locationName,price,numberOfTicketsSold);
            Event.displayAllEvents();
        }catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void removeEvent() {
        String name;
        System.out.println("Veuillez saisir le nom de l'Evenement à supprimer : ");
        name = scanner.nextLine();
        Event.deleteEvent(name);
        Event.displayAllEvents();
    }

    //Gestion des Clients
    public static void manageCustomer() {
        int choix3;
        while (true) {
            System.out.println("=== Gérer les Clients ===");
            System.out.println("1. Ajouter un Client ");
            System.out.println("2. Modifier un Client");
            System.out.println("3. Supprimer un Client ");
            System.out.println("4. Retourner menu principal ");
            System.out.print("Sélectionnez votre choix : ");
            choix3 = Integer.parseInt(scanner.nextLine());

            switch (choix3) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    editCustomer();
                    break;
                case 3:
                    removeCustomer();
                    break;
                case 4:
                    printMenu();
                    break;
            }
        }
    }
    public static void addCustomer() {
        try{
            String firstname;
            String lastname;
            String email;
            String id;
            System.out.println("Veuillez saisir l'identifiant du client' : ");
            id = scanner.next();
            scanner.nextLine();
            System.out.println("Veuillez saisir le nom du client  : ");
            lastname = scanner.next();
            scanner.nextLine();
            System.out.println("Veuillez saisir le prénom du client");
            firstname = scanner.nextLine();
            System.out.println("Veuillez saisir l'email du client ");
           email = scanner.nextLine();
           Customer newCustomer = new Customer(id,firstname,lastname,email);

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void editCustomer() {
        try{
            String firstname;
            String lastname;
            String email;
            String id;
            System.out.println("Veuillez saisir l'identifiant du client' : ");
            id = scanner.next();
            scanner.nextLine();
            System.out.println("Veuillez saisir le nom du client  : ");
            lastname = scanner.next();
            scanner.nextLine();
            System.out.println("Veuillez saisir le prénom du client");
            firstname = scanner.nextLine();
            System.out.println("Veuillez saisir l'email du client ");
            email = scanner.nextLine();
            Customer.modifyCustomer(id,firstname,lastname,email);
            Customer.displayAllCustomers();
        }catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void removeCustomer() {
        String id;
        System.out.println("Veuillez saisir l'id du client à supprimer' : ");
        id = scanner.nextLine();
        Customer.deleteClient(id);
        Customer.displayAllCustomers();
    }

    public static void buyTicketsForEvent() {
        String eventName;
        String id;
        System.out.println("Quel est id du client :");
        id = scanner.nextLine();
        System.out.println("Quel évènement souhaitez vous voir, indiquez le nom de l'évènement : ");
        eventName = scanner.nextLine();
        boolean isAvailable = Event.checkDisponibilityTicket(eventName);
       //Si c'est disponible vérifier que le client existe dans la base de données et acheter ticket


    }

    public static void cancelTicketForEvent() {

    }

    public static void displayAvailableEvent() {

    }

    public static void displayTicketsBoughtByClient() {

    }


}
