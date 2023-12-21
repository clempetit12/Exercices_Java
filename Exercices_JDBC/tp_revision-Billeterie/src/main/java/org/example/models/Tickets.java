package org.example.models;

public class Tickets {

    private int id;
    private int idCustomer;
    private int idEvent;
    private int numberTicketsBought;

    public Tickets(int idCustomer, int idEvent, int numberTicketsBought) {
        this.idCustomer = idCustomer;
        this.idEvent = idEvent;
        this.numberTicketsBought = numberTicketsBought;
    }

    public Tickets(int idEvent, int numberTicketsBought) {
        this.idEvent = idEvent;
        this.numberTicketsBought = numberTicketsBought;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getNumberTicketsBought() {
        return numberTicketsBought;
    }

    public void setNumberTicketsBought(int numberTicketsBought) {
        this.numberTicketsBought = numberTicketsBought;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
