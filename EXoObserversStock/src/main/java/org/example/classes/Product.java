package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor

public class Product implements Subject {


    private long stockLevel;

Random random = new Random();
    List<Observer> observers;

    public Product(long stockLevel) {
        this.stockLevel = stockLevel;
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
        long oldStockLevel = stockLevel;
        stockLevel = random.nextInt(0,10000);

        if (oldStockLevel != stockLevel) {
            notifyObservers(stockLevel);
        }
    }

    @Override
    public void notifyObservers(long stockLevel) {
        observers.forEach(o -> o.update(stockLevel));
    }
}
