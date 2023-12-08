package org.example.zoo;

import org.example.zoo.builder.AnimalBuilder;
import org.example.zoo.entity.Animal;

public interface Observer {
    void updateArrivalNewAnimals(Animal animal);
    void updateSpecialBehaviors(AnimalBuilder animalBuilder);
}
