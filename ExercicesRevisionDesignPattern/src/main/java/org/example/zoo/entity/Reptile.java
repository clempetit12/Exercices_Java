package org.example.zoo.entity;

import org.example.zoo.builder.MammalBuilder;
import org.example.zoo.builder.ReptileBuilder;
import org.example.zoo.entity.Animal;

public class Reptile extends Animal {
    private String color;
    private String specialBehavior;
    private int age;
    private String name;
    private String specie;

    public Reptile(ReptileBuilder builder) {
        name = builder.getName();
        specie = builder.getSpecie();
        age = builder.getAge();
        specialBehavior = builder.getSpecialBehaviour();
        color = builder.getColor();
    }

    @Override
    public String toString() {
        return "Reptile{" +
                "color='" + color + '\'' +
                ", specialBehavior='" + specialBehavior + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", specie='" + specie + '\'' +
                '}';
    }
}
