package org.example.zoo;

import org.example.zoo.builder.BirdBuilder;
import org.example.zoo.builder.MammalBuilder;
import org.example.zoo.builder.ReptileBuilder;
import org.example.zoo.entity.Animal;
import org.example.zoo.entity.Bird;
import org.example.zoo.factory.BirdFactory;
import org.example.zoo.factory.MamalFactory;
import org.example.zoo.factory.ReptileFactory;


import java.util.List;

public class Main {

    public static Zoo zoo = Zoo.getInstance();
    public static void main(String[] args) {
        List<Animal> animalZoo = zoo.getAnimalList();
        BirdFactory birdFactory = new BirdFactory();
        MamalFactory mamalFactory = new MamalFactory();
        ReptileFactory reptileFactory =new ReptileFactory();
        animalZoo.add(birdFactory.createAnimal(new BirdBuilder()
                .age(5).specie("eagle").name("toronto")));
        animalZoo.add(mamalFactory.createAnimal(new MammalBuilder()
                .age(2)
                .name("balou")
                .specie("elephant")));
        animalZoo.add(reptileFactory.createAnimal(new ReptileBuilder()
                .age(1)
                .name("yaa")
                .specie("serpent")));
        Visitors visitors1 = new Visitors();
        Visitors visitors2 = new Visitors();
        zoo.registerObserver(visitors1);
        zoo.registerObserver(visitors2);

animalZoo.add(reptileFactory.createAnimal(new ReptileBuilder().age(2)
        .specie("iguane").specialBehavior("lunatique")));

Animal bird2 = birdFactory.createAnimal(new BirdBuilder()
        .specialBehavior("fly"));



        Zoo.displayAnimalList(animalZoo);


    }
}
