package org.example.zoo.entity;

import org.example.zoo.builder.BirdBuilder;

public class Bird extends Animal {
    private String color;
    private String specialBehavior;
    private int age;
    private String name;
    private String specie;

    public Bird(BirdBuilder builder) {
        name = builder.getName();
        specie = builder.getSpecie();
        age = builder.getAge();
        specialBehavior = builder.getSpecialBehaviour();
        color = builder.getColor();
    }

    @Override
    public String toString() {
        return "Bird{" +
                "color='" + color + '\'' +
                ", specialBehavior='" + specialBehavior + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", specie='" + specie + '\'' +
                '}';
    }
}
