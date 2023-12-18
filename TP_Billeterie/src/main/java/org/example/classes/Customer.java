package org.example.classes;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@NoArgsConstructor

public class Customer {

    private String firstname;

    private String id;

    private String lastname;

    private String email;
    private ArrayList<String> listTicketsBought = new ArrayList<>();
    private static HashMap<String, Customer> customerList = new HashMap<>();

    public Customer(String id, String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.listTicketsBought = listTicketsBought;
        customerList.put(id, this);
    }

    public static Customer getCustomer(String name) {
        return customerList.get(name);
    }

    public void buyTicket(String eventName) {
        if (listTicketsBought == null) {
            ArrayList<String> listTicketsBought = new ArrayList<>();
            listTicketsBought.add(eventName);
            System.out.println(listTicketsBought);
        } else {
            listTicketsBought.add(eventName);
            System.out.println(listTicketsBought);
        }


    }

    public boolean cancelCustomerTicket(String eventName) {
        boolean eventFound = false;
        for (String e : listTicketsBought) {
            if (eventName.contains(e)) {
                listTicketsBought.remove(e);
                System.out.println("Votre billet a bien été annulé !");
                eventFound = true;
                break;
            }
        }

            if (!eventFound) {
                System.out.println("Je ne trouve pas cet évènement dans vos billets !");
                return false;
            }

            return true;
        }



    public void displayListTicketsBought(String id) {
        if (listTicketsBought.isEmpty()) {
            System.out.println("Il n'y a pas encore de tickets achetés)");
        } else {
            for (String s : listTicketsBought) {
                System.out.println("Les tickets achetés par " + id + " sont les suivants : " + s);
            }
        }
    }

    public static void modifyCustomer(String id, String lastname, String firstname, String email) {
        Customer customerUpdate = customerList.get(id);

        if (customerUpdate != null) {
            customerUpdate.setFirstname(firstname);
            customerUpdate.setLastname(lastname);
            customerUpdate.setEmail(email);
            System.out.println("Client modifié avec succès !");
        } else {
            System.out.println("Client non trouvé. La modification a échoué.");
        }
    }

    public static void displayAllCustomers() {

        for (Customer customer : customerList.values()) {
            System.out.println(customer);
        }
    }

    public static void deleteClient(String id) {
        Customer customerToDelete = customerList.get(id);

        if (customerToDelete != null) {
            customerList.remove(id);
            System.out.println("Client a été supprimé avec succès !");

        } else {
            System.out.println("Client non trouvé. La suppression a échoué.");
        }
    }


}
