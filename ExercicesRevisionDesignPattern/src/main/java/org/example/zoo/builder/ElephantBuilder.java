package org.example.zoo.builder;

import org.example.zoo.entity.Animal;
import org.example.zoo.entity.Chimpanzee;
import org.example.zoo.entity.Elephant;

public class ElephantBuilder extends AnimalBuilder {

    private String specie;
    private String name;
    private int age;
    private String color;


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
    public Animal build() {
        return new Elephant(this);
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
}
