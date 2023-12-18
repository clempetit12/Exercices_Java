package org.example.formula1race.factory;

import org.example.formula1race.builder.CarBuilder;
import org.example.formula1race.entity.Car;

public class AlpineFactory extends CarFactory{
    @Override
   public Car createCar(CarBuilder builder) {
        return builder.build();
    }
}
