package org.example.zoo;

import org.example.zoo.builder.ChimpanzeeBuilder;
import org.example.zoo.entity.Animal;
import org.example.zoo.factory.ChimpanzeeFactory;
import org.example.zoo.factory.ElephantFactory;
import org.example.zoo.factory.GirafeFactory;
import org.example.zoo.factory.GorillaFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animalZoo = new ArrayList<>();
        ChimpanzeeFactory chimpanzeeFactory = new ChimpanzeeFactory();
        ElephantFactory elephantFactory = new ElephantFactory();
        GirafeFactory girafeFactory = new GirafeFactory();
        GorillaFactory gorillaFactory = new GorillaFactory();

        animalZoo.add(chimpanzeeFactory.createAnimal(new ChimpanzeeBuilder()
                .name("Victor")
                    .age(10)
                .specie("chimpanzee")));

        Zoo.displayAnimalList(animalZoo);



    }
}
