package org.example;

import java.util.Arrays;
import java.util.List;

public class Hotel {

    public String nom;
    private List<Chambre> listChambre;
    private List<Reservation> listReservation;
    private List<Client> listClient;

    public Hotel(String nom, List<Chambre> listChambre) {
        this.nom = nom;
        this.listChambre = listChambre;
    }

    public Hotel(String nom, List<Chambre> listChambre, List<Reservation> listReservation, List<Client> listClient) {
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

    public List<Chambre> getListChambre() {
        return listChambre;
    }

    public void setListChambre(List<Chambre> listChambre) {
        this.listChambre = listChambre;
    }

    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public void setListReservation(List<Reservation> listReservation) {
        this.listReservation = listReservation;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }

    public boolean addClientToHotel(String firstname, String lastname, String phoneNumber) {
        Client client = new Client(firstname, lastname, phoneNumber);
        listClient.add(client);
        return true;
    }

    ;

    @Override
    public String toString() {
        return "Hotel{" +
                "nom='" + nom + '\'' +
                ", listChambre=" + listChambre +
                ", listReservation=" + listReservation +
                ", listClient=" + listClient +
                '}';
    }
}
