package org.example.zoo.builder;

import org.example.zoo.entity.Animal;

public abstract class AnimalBuilder {

    public abstract AnimalBuilder name(String name);
    public abstract AnimalBuilder specie(String specie);
    public abstract AnimalBuilder age(int age);
    public abstract Animal build();


}
