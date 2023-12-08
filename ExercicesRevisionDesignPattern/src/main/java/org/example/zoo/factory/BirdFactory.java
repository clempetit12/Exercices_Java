package org.example.zoo.factory;

import org.example.zoo.Zoo;
import org.example.zoo.builder.AnimalBuilder;
import org.example.zoo.builder.BirdBuilder;
import org.example.zoo.entity.Animal;

public class BirdFactory extends AnimalFactory {

    @Override
  public  Animal createAnimal(AnimalBuilder builder) {
        Animal newBird = builder.build();
        if (builder.getSpecialBehaviour() != null) {
            Zoo.getInstance().notifyObserversSpecialBehaviour(builder);
        }
        Zoo.getInstance().notifyObserversNewAnimal(newBird);
        return newBird;
    }
}
