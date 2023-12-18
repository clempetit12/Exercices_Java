package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;



public class Designer extends Employee implements EmployeeInterface {


    public Designer(int id, String firstname, String lastname, String performance, int salaire) {
        super(id, firstname, lastname, performance, salaire);
    }

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);

    }
}
