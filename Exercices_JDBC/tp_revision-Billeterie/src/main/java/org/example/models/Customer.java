package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private List<Event> listeBillets = new ArrayList<>();

    public Customer(String firstName, String lastName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.listeBillets = new ArrayList<>();
    }

    public Customer(int id, String firstName, String lastName,  String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.listeBillets = new ArrayList<>();
    }



    public void annulerBillet (Event event){
        if(event.annulerBillet()){
           this.listeBillets = this.listeBillets.stream().filter(e -> e.getName() != event.getName()).collect(Collectors.toList());
            System.out.println("le billet pour l'evenement "+event+" a bien ete annuler");
        }
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Event> getListeBillets() {
        return listeBillets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", listeBillets=" + listeBillets +
                '}';
    }
}
