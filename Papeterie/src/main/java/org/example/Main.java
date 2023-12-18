package org.example;

import org.example.classes.*;

import java.time.LocalDate;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Stylo stylo = new Stylo("s1","bic1",5,"red");
        Stylo stylo2 = new Stylo("s2","bic2",5,"yellow");
        Ramette ramette = new Ramette("r1","rammetteA",4,500);
        Ramette ramette2 = new Ramette("r2","rammetteB",3,200);
        Lot lot = new Lot("l1","s1",3,0.10);

        System.out.println(Article.getArticle("s2"));
        System.out.println();
        System.out.println(Article.getArticle("l1"));

        LocalDate dateJour = LocalDate.now();
        Facture facture = new Facture("Olivia", dateJour, 2);

      facture.ajouterLigne("l1",3);
        facture.ajouterLigne("r2", 2);
        System.out.println("Facture 1 : " + facture);
        System.out.println("Le prix total de la facture n° : " + facture.numeroFacture + " est de " + facture.getPrixTotal() + "€");

        Facture facture1 = new Facture("leo", dateJour, 1);
        facture1.ajouterLigne("s2", 4);
        System.out.println("Le prix total de la facture n° : " + facture1.numeroFacture+ " est de " + facture1.getPrixTotal()+ "€");
facture.afficherFacture();
facture1.afficherFacture();
    }
}