package org.example.classes;

public class StockManager implements Observer<Long>{


    @Override
    public void update(Long stocklevel) {
        System.out.println("StockManage est informé du changement de stock " + stocklevel);
    }
}
