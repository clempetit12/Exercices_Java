package org.example.formula1race;

import org.example.formula1race.builder.AlpineBuilder;
import org.example.formula1race.entity.Alpine;
import org.example.formula1race.entity.Car;
import org.example.formula1race.entity.Ferrari;
import org.example.formula1race.entity.RedBull;
import org.example.formula1race.factory.AlpineFactory;
import org.example.formula1race.factory.FerrariFactory;
import org.example.formula1race.factory.RedBullFactory;
import org.example.zoo.builder.BirdBuilder;
import org.example.zoo.entity.Animal;

public class Main {

    public static Race race = Race.getInstance();
    public static void main(String[] args) {
        AlpineFactory alpineFactory = new AlpineFactory();
        FerrariFactory ferrariFactory = new FerrariFactory();
        RedBullFactory redBullFactory = new RedBullFactory();

        Car alpine = alpineFactory.createCar(new AlpineBuilder()
                .aerodynamics("alpine aerodynamic")
                .chassis("alpine chassis").engine("alpine engine"));
        System.out.println(alpine);
    }
}
