package org.example.classes;

public class Supplier implements Observer {

    @Override
    public void update(long stockLevel) {
        System.out.println("Le supplier est informé du changement de stock " + stockLevel);
    }
}
