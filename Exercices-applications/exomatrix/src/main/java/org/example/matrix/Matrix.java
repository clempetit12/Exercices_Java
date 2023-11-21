package org.example.matrix;

import java.util.Scanner;

public class Matrix {
    public static Scanner scanner = new Scanner(System.in);
    static int[][] matrix = {{45, 23, 34, 56, 30}, {67, 75, 21, 52, 59}, {89, 34, 19, 19, 15}, {1, 78, 90, 48, 42}};

    public static void getSolutionExo81() {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }

            }

        }
        System.out.println("La  valeur la plus élevée est : " + max);
    }

    public static void getSolutionExo82() {
        int[][] tableau = new int[4][5];
        int nombre = 1;
        int somme = 0;
        long produit = 1;
        float moyenne = 1f;

        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                tableau[i][j] = nombre;
                nombre++;
                somme += tableau[i][j];
                produit *= tableau[i][j];

                System.out.print(tableau[i][j] + " ");


            }
            int dimension = tableau.length*tableau[i].length;
            moyenne = somme / dimension;
            System.out.println();

        }


        System.out.println("La somme est de : " + somme);
        System.out.println("Le produit est de : " + produit);
        System.out.println("La moyenne est de : " + moyenne);

    }

    public static void getSolutionExo83() {
        String[] vendeurs = {"vendeur1", "vendeur2", "vendeur3"};
        String[] marques = {"audi", "renault", "toyota"};
        String vendeur;
        String marque;
        int vendu;

        int[][] tableauVentes = new int[vendeurs.length][marques.length];

        for (int i = 0; i < tableauVentes.length; i++) {
            for (int j = 0; j < tableauVentes[i].length; j++) {
                System.out.println("Veuillez saisir le nombre vendu par " + vendeurs[i] + " de la marque " + marques[i] + " : " );
                vendu = scanner.nextInt();
                tableauVentes[i][j] = vendu;
                System.out.println(tableauVentes[i][j]);
            }

        }

        System.out.print("\t");
        for (String vend : vendeurs) {
            System.out.print(vend + "\t");
        }
        System.out.println();

        for (int i = 0; i < tableauVentes.length; i++) {
            System.out.print(marques[i] + "\t");
            for (int j = 0; j < tableauVentes[i].length; j++) {
                System.out.print(tableauVentes[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
