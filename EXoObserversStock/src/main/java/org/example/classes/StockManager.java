package org.example.classes;

public class StockManager implements Observer{

    @Override
    public void update(long stockLevel) {
        System.out.println("StockManage est informé du changement de stock " + stockLevel);
    }
}
