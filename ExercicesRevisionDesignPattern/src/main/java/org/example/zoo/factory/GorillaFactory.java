package org.example.zoo.factory;

import org.example.zoo.builder.AnimalBuilder;
import org.example.zoo.entity.Animal;
import org.example.zoo.factory.AnimalFactory;

public class GorillaFactory extends AnimalFactory {


    @Override
   public Animal createAnimal(AnimalBuilder builder) {
        return builder.build();
    }
}
