package org.example.formula1race;

import org.example.formula1race.entity.Car;
import org.example.musique.Appli;
import org.example.musique.Composition;
import org.example.musique.Sound;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static volatile Race instance = null;
    private static final Object lock = new Object();

    private Car car;
    private List<Car> carListRace;

    public List<Car> getCarList() {
        return carListRace;
    }

    private Race() {
        carListRace = new ArrayList<>();
    }

    public static Race getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new Race();
            }
        }
        return instance;
    }

    public  void displayCarList() {
        for (Car c : carListRace) {
            System.out.println(c);
        }
    }
    public  void addCarToRace(Car car) {
        carListRace.add(car);
    }


    @Override
    public String toString() {
        return "Race{" +
                "car=" + car +
                ", carListRace=" + carListRace +
                '}';
    }
}
