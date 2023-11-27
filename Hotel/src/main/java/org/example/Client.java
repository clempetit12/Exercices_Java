package org.example;

import java.util.ArrayList;
import java.util.List;

public class Client  {

    private int id;
    private String firstname;
    private String lastname;
    private String phoneNumber;


    private static int count = 0;

    {
        count++;
    }
    public Client( String firstname, String lastname, String phoneNumber) {
        this.id = count++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return  phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




    @Override
    //hérité de la classe la plus haute Object
    public String toString() {
        return "Clients{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
