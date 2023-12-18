package org.example.zoo;

import org.example.zoo.builder.AnimalBuilder;
import org.example.zoo.entity.Animal;

public class Visitors implements Observer{


    @Override
    public void updateArrivalNewAnimals(Animal animal) {
        System.out.println("Un nouvel animal est arrivé au zoo"+ animal);

    }

    @Override
    public void updateSpecialBehaviors(AnimalBuilder animalBuilder) {
        System.out.println("Cet animal a un comportement spécial " + animalBuilder.getSpecialBehaviour());
    }
}
