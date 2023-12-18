package org.example.classes;

public class Supplier implements Observer<Long> {

    @Override
    public void update(Long stockLevel) {
        System.out.println("Le supplier est informé du changement de stock " + stockLevel);
    }
}
