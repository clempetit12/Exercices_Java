package org.example;

public class Reservation {

    private double numeroReservation;
    private StatutReservation statutReservation;
    private Client client;
    private Chambre chambre;

    public Reservation(double numeroReservation, StatutReservation statutReservation, Client client, Chambre chambre) {
        this.numeroReservation = numeroReservation;
        this.statutReservation = statutReservation;
        this.client = client;
        this.chambre = chambre;
    }

    public double getNumeroReservation() {
        return numeroReservation;
    }

    public void setNumeroReservation(int numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public StatutReservation getStatutReservation() {
        return statutReservation;
    }

    public void setStatutReservation(StatutReservation statutReservation) {
        this.statutReservation = statutReservation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "numeroReservation=" + numeroReservation +
                ", statutReservation=" + statutReservation +
                ", client=" + client +
                ", chambre=" + chambre +
                '}';
    }
}
