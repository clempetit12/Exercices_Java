package org.example.formula1race.builder;

import org.example.formula1race.entity.Car;
import org.example.zoo.builder.AnimalBuilder;
import org.example.zoo.entity.Animal;

public abstract class CarBuilder {

    public abstract CarBuilder chassis(String chassis);
    public abstract CarBuilder engine(String engine);
    public abstract CarBuilder aerodynamics(String aerodynamics);
    public abstract Car build();

}
