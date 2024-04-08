package org.example.Classes.Ihm;

import org.example.models.Customer;
import org.example.models.Event;
import org.example.models.Location;
import org.example.models.Tickets;
import org.example.service.CustomerService;
import org.example.service.EventService;
import org.example.service.LocationService;
import org.example.service.TicketsService;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Ihm {

    private Scanner s = new Scanner(System.in);
    private LocationService locationService = new LocationService();
    private CustomerService customerService = new CustomerService();
    private EventService eventService = new EventService();
    private TicketsService ticketsService = new TicketsService();

    public Ihm() {
    }

    public void start() {
        this.menuGenerale();
    }

    public void menuGenerale() {
        try {
            System.out.println("----------menu---------");
            System.out.println("1/ action Lieux");
            System.out.println("2/ action Evenements");
            System.out.println("3/ action client");
            System.out.println("0/ quitter");
            System.out.println("entrer votre choix :");
            int entry = s.nextInt();
            s.nextLine();
            switch (entry) {
                case 1:
                    this.menuLieux();
                    break;
                case 2:
                    this.menuEvenement();
                    break;
                case 3:
                    this.menuCLient();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuGenerale();
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.menuGenerale();
        }

    }

    //gestion des lieux

    public void menuLieux() {
        try {
            System.out.println("----------menu Lieux---------");
            System.out.println("1/ ajouter un lieu");
            System.out.println("2/ modifier un lieu");
            System.out.println("3/ supprimer un lieu");
            System.out.println("0/ retourner au menu generale");
            System.out.println("entrer votre choix :");
            int entry = s.nextInt();
            s.nextLine();
            switch (entry) {
                case 1:
                    this.addLieux();
                    break;
                case 2:
                    this.modifLieu();
                    break;
                case 3:
                    this.suprLieu();
                    break;
                case 0:
                    this.menuGenerale();
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuLieux();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.menuLieux();
        }
    }

    public void addLieux() {
        try {
            System.out.println("--------ajouter lieu----------");
            System.out.println("entrer le nom du lieu :");
            String nomLieux = s.nextLine();
            System.out.println("entrer l'adresse du lieu :");
            String adresse = s.nextLine();
            System.out.println("entrer la capacité  du lieu :");
            long capacite = s.nextLong();
            Location location = locationService.createAndSaveLocation(nomLieux, adresse, capacite);
            this.menuLieux();
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.addLieux();
        }
    }

    public void modifLieu() {
        try {
            try {
                System.out.println("--------modifier lieu----------");

                System.out.println("quelle lieux vouler vous modifier entrez id du lieu : ");
                int entry = s.nextInt();
                s.nextLine();
                Location location = locationService.getLocationById(entry);
                if (location != null) {
                    System.out.println("entrer le nouveau nom : ");
                    String nom = s.nextLine();
                    System.out.println("entrer la nouvelle adresse : ");
                    String adresse = s.nextLine();
                    System.out.println("entrer la nouvelle capacité  du lieu :");
                    long capacite = s.nextLong();
                    Location newLocation = new Location(location.getId(), nom, adresse, capacite);
                    locationService.updateLocation(newLocation);

                }

                this.menuLieux();
            } catch (IndexOutOfBoundsException e) {
                this.menuLieux();
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.modifLieu();
        }
    }

    public void suprLieu() {
        try {
            System.out.println("--------supr lieu----------");
            System.out.println("quelle lieux voulez vous supprimer (0 pour retour) précisez l'id: ");
            int entry = s.nextInt();

            if (entry == 0) {
                this.menuLieux();
            } else {
                Location location = locationService.getLocationById(entry);
                if (location != null) {
                    locationService.deleteLocation(location.getId());
                    System.out.println("le lieux a bien ete supprimer");
                }

                this.menuLieux();
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.suprLieu();
        }
    }


    // gestion des evenements

    public void menuEvenement() {
        try {
            System.out.println("----------menu Evenement---------");
            System.out.println("1/ ajouter un Evenement");
            System.out.println("2/ modifier un Evenement");
            System.out.println("3/ supprimer un Evenement");
            System.out.println("4/ afficher la liste des evenements disponibles");
            System.out.println("0/ retourner au menu generale");
            System.out.println("entrer votre choix :");
            int entry = s.nextInt();
            switch (entry) {
                case 1:
                    this.addEvenement();
                    break;
                case 2:
                    this.updateEvent();
                    break;
                case 3:
                    this.suprEvenement();
                    break;
                case 4:
                    this.afficherListEventsDisponibles();
                    break;
                case 0:
                    this.menuGenerale();
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuEvenement();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.menuCLient();
        }
    }

    private void updateEvent() {
        try {
            try {
                System.out.println("--------modifier évènement----------");

                System.out.println("quelle évènement vouler vous modifier entrez id de l'évènement : ");
                int entry = s.nextInt();
                Event event = eventService.getEventById(entry);
                if (event != null) {
                    System.out.println("entrer le nom de l'evenement:");
                    String nom = s.next();

                    System.out.println("Entrez la date de l'événement (format dd-MM-yyyy) :");
                    String dateString = s.next();
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate date = LocalDate.parse(dateString, dateFormatter);

                    System.out.println("Entrez l'heure de l'événement (format HH:mm:ss) :");
                    String heureString = s.next();
                    DateTimeFormatter heureFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime hour = LocalTime.parse(heureString, heureFormatter);

                    System.out.println();

                    System.out.println("selectionner le lieu de l'evenement :");
                    int lieux = s.nextInt();

                    System.out.println("entrer le prix du billet");
                    float prix = s.nextFloat();

                    System.out.println("combien de tickets vendus");
                    int numberTicketsSold = s.nextInt();
                    Event newEvent = new Event(event.getId(), nom, date, hour, lieux, prix, numberTicketsSold);
                    eventService.updateEvent(newEvent);
                }

                this.menuLieux();
            } catch (IndexOutOfBoundsException e) {
                this.menuLieux();
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.modifLieu();
        }
    }

    private void afficherListEventsDisponibles() {
        eventService.getAvailableEvents().forEach(e -> System.out.println(e));
        this.menuEvenement();
    }

    public void addEvenement() {
        try {
            System.out.println("--------ajouter Evenement----------");

            System.out.println("entrer le nom de l'evenement:");
            String nom = s.next();

            System.out.println("Entrez la date de l'événement (format dd-MM-yyyy) :");
            String dateString = s.next();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(dateString, dateFormatter);

            System.out.println("Entrez l'heure de l'événement (format HH:mm:ss) :");
            String heureString = s.next();
            DateTimeFormatter heureFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime hour = LocalTime.parse(heureString, heureFormatter);

            System.out.println();

            System.out.println("selectionner le lieu de l'evenement :");
            int lieux = s.nextInt();

            System.out.println("entrer le prix du billet");
            float prix = s.nextFloat();

            System.out.println("combien de tickets vendus");
            int numberTicketsSold = s.nextInt();

            eventService.createAndSaveEvent(nom, date, hour, lieux, prix, numberTicketsSold);
            this.menuEvenement();
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.addEvenement();
        }
    }

    public void suprEvenement() {
        try {
            System.out.println("--------supr evenement----------");
            System.out.println("quel evenement voulez vous supprimer (0 pour retour) précisez l'id : ");
            int entry = s.nextInt();

            Event event = eventService.getEventById(entry);
            if (event != null) {
                eventService.deleteEvent(event.getId());
            }
            this.menuEvenement();

        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.suprEvenement();
        }
    }

    //gestion client

    public void menuCLient() {
        try {
            System.out.println("----------menu Client---------");
            System.out.println("1/ ajouter un Client");
            System.out.println("2/ modifier un Client");
            System.out.println("3/ supprimer un Client");
            System.out.println("4/ acheter un billet");
            System.out.println("5/ annuler un billet");
            System.out.println("6/ afficher la liste des billets d'un clients");
            System.out.println("0/ retourner au menu generale");
            System.out.println("entrer votre choix :");
            int entry = s.nextInt();
            switch (entry) {
                case 1:
                    this.addClient();
                    break;
                case 2:
                    this.modifClient();
                    break;
                case 3:
                    this.suprClient();
                    break;
                case 4:
                    achatBillet();
                    break;
                case 5:
                    annulationBillet();
                    break;
                case 6:
                    affichageBillet();
                    break;
                case 0:
                    this.menuGenerale();
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuCLient();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.menuCLient();
        }
    }


    public void addClient() {
        try {
            System.out.println("--------ajouter CLient----------");
            System.out.println("entrer le nom du clien :");
            String nom = s.next();

            System.out.println("entrer le prenom du client :");
            String prenom = s.next();

            System.out.println("entrer l'email du client : ");
            String email = s.next();

            customerService.createAndSaveCustomer(prenom, nom, email);
            this.menuCLient();
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.addEvenement();
        }
    }

    public void modifClient() {
        try {
            try {
                System.out.println("--------modifier Client----------");
                System.out.println("quel Client vouler vous modifier précisez id : ");
                int entry = s.nextInt();
                Customer customer = customerService.getCustomerById(entry);
                if (customer != null) {
                    System.out.println("entrer le nouveau nom : ");
                    String nom = s.next();
                    System.out.println("entrer le nouveau prenom : ");
                    String prenom = s.next();
                    System.out.println("entrer la nouvelle adresse email : ");
                    String email = s.next();
                    Customer updateCustomer = new Customer(customer.getId(), prenom, nom, email);
                    customerService.updateCustomer(updateCustomer);

                }
                this.menuCLient();
            } catch (IndexOutOfBoundsException e) {
                this.menuCLient();
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.modifClient();
        }
    }

    public void suprClient() {
        try {
            System.out.println("--------supr CLient----------");
            System.out.println("quel Client voulez vous supprimer précisé id (0 pour retour) : ");
            int entry = s.nextInt();

            if (entry == 0) {
                this.menuLieux();
            } else {
                Customer customer = customerService.getCustomerById(entry);
                if (customer != null) {
                    customerService.deleteCustomer(customer.getId());
                    System.out.println("le customer a bien ete supprimé");
                }

                this.menuCLient();

            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.suprLieu();
        }
    }


    public void achatBillet() {
        try {

            System.out.println("---------achat billet -----------");

            System.out.println("précisez l'id du client :");
            int client = s.nextInt();
            Customer customer = customerService.getCustomerById(client);
            if (customer != null) {
                System.out.println("choisissez  un évènement précisez l'id");
                int event = s.nextInt();
                System.out.println("précisez le nombre de places à acheter");
                int nombreTickets = s.nextInt();
                Event event1 = eventService.getEventById(event);
                Tickets tickets = new Tickets(client, event, nombreTickets);
                if (ticketsService.buyTickets(tickets)) {
                    event1.setnumberticketsSold(event1.getnumberticketsSold() + tickets.getNumberTicketsBought());
                    eventService.updateEventTicketsSold(event1);
                }
            } else {
                System.out.println("il n'y a pas de client avec cet id");
            }
            this.menuCLient();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index out of bound");
            this.menuCLient();
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur valide");
        }
    }

    private void annulationBillet() {
        try {

            System.out.println("---------annulation billet -----------");

            System.out.println("précisez l'id de la vente :");
            int idVente = s.nextInt();
            Tickets tickets = ticketsService.getTicketById(idVente);
            if (tickets != null) {
                if (ticketsService.cancelTicket(idVente)) {
                    Event event = eventService.getEventById(tickets.getIdEvent());
                    event.setnumberticketsSold(event.getnumberticketsSold() - tickets.getNumberTicketsBought());
                    eventService.updateEventTicketsSold(event);
                }
            }


            this.menuCLient();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index out of bound");
            this.menuCLient();
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur valide");
        }
    }

    public void affichageBillet() {
        try {
            System.out.println("---------afffichage des billets----------");

            System.out.println("choisissez un client :");
            int client = s.nextInt();
            ticketsService.getTicketBoughtByCustomer(client).forEach(e -> System.out.println(e));
            this.menuCLient();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index out of bound");
            this.menuCLient();
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur valide");
            this.affichageBillet();
        }
    }


}
