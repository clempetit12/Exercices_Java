package org.example.classes;

public class Manager extends Employee implements EmployeeInterface{
    public Manager(String firstname, String lastname) {
        super(firstname, lastname);
    }


    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }
}
