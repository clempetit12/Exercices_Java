package org.example.nom;

import java.util.Scanner;

public class Noms {
    public static void getNomsOrdreAlphabetique() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ecrivez un premier nom : ");
        String nom1 = scanner.next();
        System.out.println("Ecrivez un deuxième nom : ");
        String nom2 = scanner.next();
        System.out.println("Ecrivez un troisième nom : ");
        String nom3 = scanner.next();
        char premiereLettreNom1 = nom1.charAt(0);
        char premiereLettreNom2 = nom2.charAt(0);
        char premiereLettreNom3 = nom3.charAt(0);
        if (premiereLettreNom3 <= premiereLettreNom2 && premiereLettreNom2 <= premiereLettreNom1) {
            System.out.println("Les noms sont rangés dans l'ordre alphabétique");
        } else {
            System.out.println("Les noms ne sont pas rangés dans l'ordre alphabétique");
        }
    }
}
