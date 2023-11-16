package org.example.variables;

import java.util.Scanner;

public class Variables {

    public static Scanner s = new Scanner(System.in);

    public static void getSolutionExoAgeEnfant() {
        int age = 0;
        System.out.println("Quel âge a votre enfant ?");
        age = s.nextInt();
        if (age < 6) {
            System.out.println("Votre enfant est trop jeune");

        } else if ((6 <= age) && (age <= 7)) {
            System.out.println("Votre enfant est dans la catégorie Poussin");
        } else if ((8 <= age) && (age <= 9)) {
            System.out.println("Votre enfant est dans la catégorie Pupille");
        } else if ((10 <= age) && (age <= 11)) {
            System.out.println("Votre enfant est dans la catégorie Minime");
        } else {
            System.out.println("Votre enfant est dans la catégorie Cadet");
        }
        s.close();
    }

    public static void getNombreDivisibleParTrois() {
        int nombre = 0;
        System.out.println("Veuillez saisir un nombre entier : ");
        nombre = s.nextInt();
        if(nombre%3==0) {
            System.out.println("Voitre nombre est divisible par 3 !");
        } else {
            System.out.println("Voitre nombre n'est pas divisible par 3 !");
        }
        s.close();

    }

    public static void getPrixPhotocopie() {
        int nombrePhotocopies = 0;
        float prixPhotocopie = 0f;
        float prixTotal = 0f;
        System.out.println("Veuillez indiquez le nombre de photocopies à effectuer : ");
        nombrePhotocopies = s.nextInt();
        if (nombrePhotocopies < 10) {
            prixPhotocopie = 0.15f;


        } else if ((10 <= nombrePhotocopies) && (nombrePhotocopies)<= 20) {
            prixPhotocopie = 0.10f;
            
        } else {
            prixPhotocopie = 0.05f;
        }
        prixTotal = nombrePhotocopies * prixPhotocopie;
        System.out.println("Le prix à payer est de : "+ prixTotal + "€");
        s.close();
    }

}
