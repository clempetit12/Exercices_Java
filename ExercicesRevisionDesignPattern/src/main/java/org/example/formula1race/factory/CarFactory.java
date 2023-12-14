package org.example.formula1race.factory;

import org.example.formula1race.builder.CarBuilder;
import org.example.formula1race.entity.Car;

public abstract class CarFactory {

    abstract Car createCar(CarBuilder builder);
}
