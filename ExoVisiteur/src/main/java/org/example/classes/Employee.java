package org.example.classes;

public abstract class Employee {

    private int id;
    private String firstname;
    private String lastname;

    public static int count = 0;

    public Employee( String firstname, String lastname) {
        this.id = count++;
        this.firstname = firstname;
        this.lastname = lastname;
    }



    public String getFirstname() {
        return firstname;
    }





    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
