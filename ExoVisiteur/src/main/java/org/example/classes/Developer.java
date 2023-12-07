package org.example.classes;

public class Developer extends Employee implements EmployeeInterface{
    public Developer(String firstname, String lastname) {
        super(firstname, lastname);
    }

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }


}
