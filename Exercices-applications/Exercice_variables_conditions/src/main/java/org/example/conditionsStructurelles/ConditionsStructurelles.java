package org.example.conditionsStructurelles;

import java.util.ArrayList;
import java.util.Scanner;

public class ConditionsStructurelles {
    public static Scanner s = new Scanner(System.in);

    public static void getNombre() {
        int nombre = 0;


        do {
            System.out.println("Veuillez saisir un nombre entre 1 et 3 : ");
            nombre = s.nextInt();
            if (nombre < 1 || nombre > 3) {

            }

        }
        while (nombre < 1 || nombre > 3);
        s.close();

    }

    public static void getSolutionExercice52() {
        int nombre = 0;
        do {
            System.out.println("Veuillez saisir un nombre entre 10 et 20 : ");
            nombre = s.nextInt();
            if (nombre < 10) {
                System.out.println("Plus grand !");
            } else if (nombre > 20) {
                System.out.println("Plus petit !");
            } else {
                System.out.println("Bravo !");
            }


        }
        while (nombre < 10 || nombre > 20);
        s.close();


    }

    public static void getSolution53() {
        int nombre = 0;
        System.out.println("Veuillez saisir un nombre : ");
        nombre = s.nextInt();
        for (int i = nombre; i < nombre + 11; i++) {
            System.out.println("i = " + (i));
        }
        s.close();

    }

    public static void getSolution55() {
        int nombre = 0;
        System.out.println("Veuillez saisir un nombre : ");
        nombre = s.nextInt();
        System.out.println("----- Table de multiplication de " + nombre + "-----");
        for (int i = nombre; i < nombre + 1; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.println(i + " x " + j + " = " + i * j);

            }
        }
        s.close();

    }

    public static void getSolution56() {
        int nombre = 0;
        int sum = 0;
        System.out.print("Veuillez saisir un nombre : ");
        nombre = s.nextInt();
        for (int i = 1; i < nombre; i++) {
            sum += i;
            System.out.print(i + "+");
        }
        sum += nombre;
        System.out.print(nombre + "= " + sum);
    }

    public static void getSolution57() {
        int[] tabNombre = new int[20];
        int max = -100;


        for (int i = 1; i < tabNombre.length; i++) {
            System.out.println("Veuillez saisir le nombre" + i + " : ");
            tabNombre[i] = s.nextInt();

        }
        for (int numb : tabNombre) {
            if (numb > max) {
                max = numb;
            }

        }
        System.out.println("Le nombre max est " + max);
    }


    public static void getSolution58() {
        int[] tabNombre = new int[5];
        int max = -100;
        int index = 0;


        for (int i = 1; i < tabNombre.length; i++) {
            System.out.println("Veuillez saisir le nombre" + i + " : ");
            tabNombre[i] = s.nextInt();

        }
        int i = 0;
        for (int numb : tabNombre) {
            if (numb > max) {
                max = numb;
                index = i;

            }
            i++;

        }
        System.out.println("Le nombre max est " + max);
        System.out.println("C'était le nombre numéro :  " + index);
    }

    public static void getSolution59() {

        int nombre = 0;
        int produit = 1;
        System.out.print("Veuillez saisir un nombre : ");
        nombre = s.nextInt();
        for (int i = 1; i < nombre; i++) {
            produit *= i;
            if (i <= nombre) {
                System.out.print(i + " x ");
            }

        }

        System.out.print(nombre + " = " + produit);
        s.close();


    }

    public static void getSolution60() {
        ArrayList<Integer> nombres = new ArrayList<>();
        int nombre;

        do {

            System.out.println("Veuillez saisir le nombre : ");
            nombre = s.nextInt();
            if (nombre != 0) {
                nombres.add(nombre);
            }
        }

        while (nombre != 0);
        s.close();

        int max = -100;
        int index = 0;

        int i = 0;
        for (int numb : nombres) {
            if (numb > max) {
                max = numb;
                index = i;
            }
            i++;
        }
        System.out.println("Le nombre max est " + max);
        System.out.println("C'était le nombre numéro :  " + index);


    }

    public static void getSolution61() {
        ArrayList<Integer> achats = new ArrayList<>();
        int prix;
        int somme = 0;
        int paye;
        int rendu = 0;

        do {

            System.out.println("Veuillez saisir le prix de votre achat : ");
            prix = s.nextInt();
            if (prix != 0) {
                achats.add(prix);
            }
        }

        while (prix != 0);


        for (int numb : achats
        ) {
            somme += numb;

        }
        System.out.println("Le coût total est de  : " + somme);
        System.out.println("Payé : ");
        paye = s.nextInt();

        rendu = paye - somme;

        if (rendu>0) {
            System.out.println("Le rendu est de : "+ rendu + "Euros");
        }
        int coupures10 = rendu/10;
        rendu %= 10;

        int coupures5 = rendu/5;
        rendu %= 5;

        int coupures1 = rendu/1;
        rendu %= 1;

        if (coupures10>0) {
            System.out.println("Coupures de 10 : "+ coupures10);
        }
        if (coupures5>0) {
            System.out.println("Coupures de 5 : "+ coupures5);
        }
        if (coupures1>0) {
            System.out.println("Coupures de 1 : "+ coupures1);
        }

        System.out.println(rendu + "Euros");


    }

    public static void getSolution62() {
        int n = 0;
        int somme = 0;

        for (int i = 1; somme < 100 ; i++) {
            somme += i;
            n++;
            if (somme > 100) {
                System.out.println(" Le premier nombre entier n qui dépasse strictement 100 est : " + n);
            }

        }


    }
}





