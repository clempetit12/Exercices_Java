package org.example.zoo.builder;

import org.example.zoo.entity.Animal;
import org.example.zoo.entity.Bird;

public class BirdBuilder extends AnimalBuilder{

    private String specie;
    private String name;
    private int age;
    private String color;
    private String specialBehavior;



    @Override
    public AnimalBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public AnimalBuilder specie(String specie) {
        this.specie = specie;
        return this;
    }

    @Override
    public AnimalBuilder age(int age) {
        this.age = age;
        return this;
    }

    @Override
    public AnimalBuilder specialBehavior(String specialBehavior) {
        this.specialBehavior = specialBehavior;
        return this;
    }

    @Override
    public String  getSpecialBehaviour() {
        return specialBehavior;
    }

    @Override
    public Animal build() {
        return new Bird(this);
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public void setSpecialBehavior(String specialBehavior) {
        this.specialBehavior = specialBehavior;
    }

    @Override
    public String toString() {
        return "BirdBuilder{" +
                "specie='" + specie + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", specialBehavior='" + specialBehavior + '\'' +
                '}';
    }
}
