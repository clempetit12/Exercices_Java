package org.example.zoo.entity;

import org.example.zoo.builder.ChimpanzeeBuilder;

public class Chimpanzee extends Animal{

    private String specie;
    private String name;
    private int age;
    private String color;

    public Chimpanzee(ChimpanzeeBuilder builder) {
        specie = builder.getSpecie();
        name = builder.getName();
        age = builder.getAge();
        color = builder.getColor();
    }
}
