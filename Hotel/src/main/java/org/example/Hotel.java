package org.example;

import java.util.Arrays;

public class Hotel {

    public String nom;
    private Chambre[] listChambre;
    private Reservation[] listReservation;
    private Client[] listClient;

    public Hotel(String nom, Chambre[] listChambre) {
        this.nom = nom;
        this.listChambre = listChambre;
    }

    public Hotel(String nom, Chambre[] listChambre, Reservation[] listReservation, Client[] listClient) {
        this.nom = nom;
        this.listChambre = listChambre;
        this.listReservation = listReservation;
        this.listClient = listClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Chambre[] getListChambre() {
        return listChambre;
    }

    public void setListChambre(Chambre[] listChambre) {
        this.listChambre = listChambre;
    }

    public Reservation[] getListReservation() {
        return listReservation;
    }

    public void setListReservation(Reservation[] listReservation) {
        this.listReservation = listReservation;
    }

    public Client[] getListClient() {
        return listClient;
    }

    public void setListClient(Client[] listClient) {
        this.listClient = listClient;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nom='" + nom + '\'' +
                ", listChambre=" + Arrays.toString(listChambre) +
                ", listReservation=" + Arrays.toString(listReservation) +
                ", listClient=" + Arrays.toString(listClient) +
                '}';
    }
}
