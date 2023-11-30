package org.example.exercice3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            int[] tabEntiers;
            tabEntiers = new int[]{1, 2, 3, 4, 5};
            System.out.println("Accédez au sixième élément : " + tabEntiers[5]);


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erreur d'index de tableau : " + e.getMessage());
        }

    }
}
