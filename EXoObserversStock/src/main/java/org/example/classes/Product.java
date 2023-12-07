package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class Product implements Subject {

    private double stockLevel;
    private Random random = new Random();

    List<Observer> observers;

    public Product() {
        observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
observers.remove(observer);
    }
    public void randomStock() {
        double oldStockLevel = stockLevel;
        stockLevel = random.nextDouble();

        if (oldStockLevel != stockLevel) {
            notifyObservers(stockLevel);
        }
    }

    @Override
    public void notifyObservers(double stockLevel) {
        observers.forEach(o -> o.update(stockLevel));
    }
}
