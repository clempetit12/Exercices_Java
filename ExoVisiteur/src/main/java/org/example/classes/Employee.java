package org.example.classes;

public abstract class Employee {

    private int id;
    private String firstname;
    private String lastname;

    private String performance;
    private int salaire;

    public static int count = 0;


    public Employee(int id, String firstname, String lastname, String performance, int salaire) {
        this.id = count++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.performance = performance;
        this.salaire = salaire;
    }

    public String getFirstname() {
        return firstname;
    }


    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salaire=" + salaire +
                '}';
    }
}
