package org.example.formula1race.builder;

import org.example.formula1race.entity.Alpine;
import org.example.formula1race.entity.Car;

public class AlpineBuilder extends CarBuilder{

    private String chassis;
    private String engine;
    private String aerodynamics;

    @Override
    public CarBuilder chassis(String chassis) {
        this.chassis = chassis;
        return this;
    }

    @Override
    public CarBuilder engine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public CarBuilder aerodynamics(String aerodynamics) {
        this.aerodynamics = aerodynamics;
        return this;
    }

    @Override
    public Car build() {
        return new Alpine(this);
    }

    public String getChassis() {
        return chassis;
    }

    public String getEngine() {
        return engine;
    }


    public String getAerodynamics() {
        return aerodynamics;
    }

    @Override
    public String toString() {
        return "AlpineBuilder{" +
                "chassis='" + chassis + '\'' +
                ", engine='" + engine + '\'' +
                ", aerodynamics='" + aerodynamics + '\'' +
                '}';
    }
}
