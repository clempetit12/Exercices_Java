package org.example.zoo.factory;

import org.example.zoo.Zoo;
import org.example.zoo.builder.AnimalBuilder;
import org.example.zoo.builder.MammalBuilder;
import org.example.zoo.entity.Animal;

public class MamalFactory extends AnimalFactory{
    @Override
  public  Animal createAnimal(AnimalBuilder builder) {
        Animal newMamal = builder.build();
        if (builder.getSpecialBehaviour() != null) {
            Zoo.getInstance().notifyObserversSpecialBehaviour(builder);
        }
        Zoo.getInstance().notifyObserversNewAnimal(newMamal);
        return newMamal;
    }
}
