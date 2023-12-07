package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;



public class Designer extends Employee implements EmployeeInterface {
    public Designer(String firstname, String lastname) {
        super(firstname, lastname);
    }




    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);

    }
}
