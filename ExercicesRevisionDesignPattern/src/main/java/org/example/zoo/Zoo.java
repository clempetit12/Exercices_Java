package org.example.zoo;

import org.example.zoo.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private static volatile Zoo instance = null;
    private static final Object lock = new Object();
    private List<Animal> animalList;

    public List<Animal> getAnimalList() {
        return animalList;
    }

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
}
