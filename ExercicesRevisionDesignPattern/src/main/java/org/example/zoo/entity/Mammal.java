package org.example.zoo.entity;

import org.example.zoo.builder.BirdBuilder;
import org.example.zoo.builder.MammalBuilder;

public class Mammal extends Animal {
    private String color;
    private String specialBehavior;
    private int age;
    private String name;
    private String specie;

    public Mammal(MammalBuilder builder) {
        name = builder.getName();
        specie = builder.getSpecie();
        age = builder.getAge();
        specialBehavior = builder.getSpecialBehaviour();
        color = builder.getColor();
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "color='" + color + '\'' +
                ", specialBehavior='" + specialBehavior + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", specie='" + specie + '\'' +
                '}';
    }
}
