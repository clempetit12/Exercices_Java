package org.example.classes;

public interface Subject<T> {
    void notifyObservers(Long element);

    void registerObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);

    void notifyObservers(T element);
}
