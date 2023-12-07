package org.example.zoo.entity;

import org.example.zoo.builder.ChimpanzeeBuilder;
import org.example.zoo.builder.ElephantBuilder;

public class Elephant extends Animal{

    private String specie;
    private String name;
    private int age;
    private String color;

    public Elephant(ElephantBuilder builder) {
        specie = builder.getSpecie();
        name = builder.getName();
        age = builder.getAge();
        color = builder.getColor();
    }
}
