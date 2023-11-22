package org.example;

import org.example.maison.Appartement;
import org.example.maison.Person;
import org.example.maison.Porte;

public class Main {
    public static void main(String[] args) {

        Porte porte = new Porte("bleu");
        Appartement appartement = new Appartement(porte);
        Person personne = new Person("Jean", appartement);
        personne.display();
        porte.displayDoor();


    }
}