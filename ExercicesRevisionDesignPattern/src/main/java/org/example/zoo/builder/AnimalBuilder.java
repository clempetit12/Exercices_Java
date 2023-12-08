package org.example.zoo.builder;

import org.example.zoo.entity.Animal;

public abstract class AnimalBuilder {

    public abstract AnimalBuilder name(String name);
    public abstract AnimalBuilder specie(String specie);
    public abstract AnimalBuilder age(int age);
    public abstract AnimalBuilder specialBehavior(String specialBehavior);
    public abstract String getSpecialBehaviour();
    public abstract Animal build();


}
