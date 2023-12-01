package org.example.classes;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
    @NonNull
    private String firstname;
    @NonNull
    private String id;
    @NonNull
    private String lastname;
    @NonNull
    private String email;
    private ArrayList<Event> listTicketsBought;
    private static HashMap<String, Customer> customerList = new HashMap<>();

    public Customer(@NonNull String firstname, @NonNull String id, @NonNull String lastname, @NonNull String email, ArrayList<Event> listTicketsBought) {
        this.firstname = firstname;
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.listTicketsBought = listTicketsBought;
        customerList.put(id,this);
    }

    public void buyTicket(Event event) {
        if (event.checkDisponibilityTicket()) {
            listTicketsBought.add(event);
            event.sellTicket();

        } else {
            System.out.println("Il n'y a plus de disponibilités pour cet évènement !");
        }

    }
    public void cancelCustomerTicket(Event event) {
        event.cancelTicket();
            listTicketsBought.remove(event);
            System.out.println("Votre billet a bien été annulé !");


    }

    public void displayEvents () {
        if (listTicketsBought == null){
            ArrayList<Event> listTicketsBought = new ArrayList<>();

        } else {
            System.out.println("Vos prochains évènements : ");
            for (Event e: listTicketsBought) {
                System.out.println(e);
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
        }}

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
