package org.example.produit;

import java.util.Scanner;

public class Produits {
    public static void getNegPosProduit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez le nombre 1 : ");
        int nombre1 = scanner.nextInt();
        System.out.println("Saisissez le nombre 2 : ");
        int nombre2 = scanner.nextInt();
        if ((nombre2>0 & nombre1>0) ||(nombre2 <0 & nombre1<0) ) {
            System.out.println("Le produit est positif");
        } else {
            System.out.println("Le produit est négatif");
        }

    }
}
