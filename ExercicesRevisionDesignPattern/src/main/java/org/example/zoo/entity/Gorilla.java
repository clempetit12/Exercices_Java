package org.example.zoo.entity;

import org.example.zoo.builder.ElephantBuilder;
import org.example.zoo.builder.GorillaBuilder;

public class Gorilla extends Animal{

    private String specie;
    private String name;
    private int age;
    private String color;

    public Gorilla(GorillaBuilder builder) {
        specie = builder.getSpecie();
        name = builder.getName();
        age = builder.getAge();
        color = builder.getColor();
    }
}
