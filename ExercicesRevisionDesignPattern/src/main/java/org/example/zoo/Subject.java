package org.example.zoo;

import org.example.zoo.builder.AnimalBuilder;
import org.example.zoo.entity.Animal;

public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    void notifyObserversNewAnimal(Animal animal);
    void notifyObserversSpecialBehaviour(AnimalBuilder animalBuilder);
}
