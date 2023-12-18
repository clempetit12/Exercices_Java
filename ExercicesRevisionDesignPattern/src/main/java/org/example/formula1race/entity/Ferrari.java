package org.example.formula1race.entity;

import org.example.formula1race.builder.AlpineBuilder;
import org.example.formula1race.builder.FerraryBuilder;

public class Ferrari extends Car {
    private String chassis;
    private String engine;
    private String aerodynamics;

    public Ferrari(FerraryBuilder builder) {
        chassis = builder.getChassis();
        engine = builder.getEngine();
        aerodynamics = builder.getAerodynamics();
    }


    @Override
    public String toString() {
        return "Alpine{" +
                "chassis='" + chassis + '\'' +
                ", engine='" + engine + '\'' +
                ", aerodynamics='" + aerodynamics + '\'' +
                '}';
    }
}

