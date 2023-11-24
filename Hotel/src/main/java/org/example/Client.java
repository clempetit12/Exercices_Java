package org.example;

import java.util.List;

public class Client  {

    private int id;
    private String firstname;
    private String lastname;
    private int phoneNumber;

    private static int count = 0;

    {
        count++;
    }
    public Client( String firstname, String lastname, int phoneNumber) {
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




    @Override
    public String toString() {
        return "Clients{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
