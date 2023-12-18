package org.example.classes;

public class Developer extends Employee implements EmployeeInterface{


    public Developer(int id, String firstname, String lastname, String performance, int salaire) {
        super(id, firstname, lastname, performance, salaire);
    }

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }


}
