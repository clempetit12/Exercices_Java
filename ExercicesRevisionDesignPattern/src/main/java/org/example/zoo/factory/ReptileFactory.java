package org.example.zoo.factory;

import org.example.zoo.Zoo;
import org.example.zoo.builder.AnimalBuilder;
import org.example.zoo.entity.Animal;

public class ReptileFactory extends AnimalFactory{
    @Override
  public  Animal createAnimal(AnimalBuilder builder) {
        Animal newReptile = builder.build();
        if (builder.getSpecialBehaviour() != null) {
            Zoo.getInstance().notifyObserversSpecialBehaviour(builder);
        }
        Zoo.getInstance().notifyObserversNewAnimal(newReptile);
        return newReptile;
    }
}
