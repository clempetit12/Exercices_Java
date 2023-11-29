package org.example;

import org.example.classes.*;

import java.time.LocalDate;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Stylo stylo = new Stylo("bic", 5, "red");
        Stylo stylo2 = new Stylo("bic2", 4, "yellow");
        Stylo stylo3 = new Stylo("bic3", 3, "blue");
        Ramette ramette = new Ramette("rammetteB", 4, 5);
        Ramette ramette2 = new Ramette("rammetteC", 2, 4);
        Ramette ramette3 = new Ramette("rammetteD", 1, 2);
        Lot lot = new Lot(stylo, 5, 0.05);

        HashMap<Long, Article> bdd = Article.bdd;

        for (Long k : bdd.keySet()
        ) {
            Article article = bdd.get(k);
            System.out.println(article);

        }

        LocalDate dateJour = LocalDate.now();
        Facture facture = new Facture("Olivia", dateJour, 2);
        System.out.println("Facture 1 : " + facture);
        facture.ajouterLigne(stylo3, 5);
        System.out.println("Facture 1 : " + facture);
        System.out.println("Facture 1 avec deux lignes : " + facture);
        facture.ajouterLigne(ramette3, 2);

        System.out.println("Le prix total de la facture n° : " + facture.numeroFacture+ " est de " + facture.getPrixTotal()+ "€");

        Facture facture2 = new Facture("Leo",dateJour,1);

    }
}