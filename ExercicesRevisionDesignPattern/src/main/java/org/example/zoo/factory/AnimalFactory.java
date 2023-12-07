package org.example.zoo.factory;

import org.example.zoo.builder.AnimalBuilder;
import org.example.zoo.entity.Animal;

public abstract class AnimalFactory {

abstract Animal createAnimal(AnimalBuilder builder);

}
