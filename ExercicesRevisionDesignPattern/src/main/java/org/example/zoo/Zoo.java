package org.example.zoo;

import org.example.zoo.builder.AnimalBuilder;
import org.example.zoo.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo implements Subject {

    private static volatile Zoo instance = null;
    private static final Object lock = new Object();
    private List<Animal> animalList;

    public List<Animal> getAnimalList() {
        return animalList;
    }

    List<Observer> observers = new ArrayList<>();


    private Zoo() {
        animalList = new ArrayList<>();

    }

    public static Zoo getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new Zoo();
            }
        }
        return instance;
    }

    public static void displayAnimalList(List<Animal> animalList) {
        for (Animal a : animalList) {
            System.out.println(a);
        }
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "animalList=" + animalList +
                '}';
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserversNewAnimal(Animal animal) {
        for (Observer o : observers
        ) {

            o.updateArrivalNewAnimals(animal);

        }
    }

    @Override
    public void notifyObserversSpecialBehaviour(AnimalBuilder animalBuilder) {

        for (Observer o : observers
        ) {
            if (animalBuilder.getSpecialBehaviour() != null) {
                o.updateSpecialBehaviors(animalBuilder);
            }

        }
    }

}
