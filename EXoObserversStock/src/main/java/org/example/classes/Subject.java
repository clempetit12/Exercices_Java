package org.example.classes;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    void notifyObservers(double stockLevel);
}
