package org.example.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Facture {

    private static final int NB_MAX_LIGNES = 10;
    public static long count = 1;
    public long numeroFacture;


    static {
        count++;
    }

    Ligne[] lignes;

    String client;
    LocalDate date;

    int nombreDeLignes;

    public Facture(String client, LocalDate date, int nombreDeLignes) {
        this.numeroFacture = count++;
        this.lignes = new Ligne[nombreDeLignes];
        this.client = client;
        this.date = date;

    }
    public Facture(String client, LocalDate date) {
        this(client,date,NB_MAX_LIGNES);
    }

    public Facture(Ligne[] lignes) {
        this.lignes = lignes;
    }

    public long getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(int numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    public void ajouterLigne(String idArticle, int quantityArticle) {
        if (lignes == null) {
            lignes = new Ligne[nombreDeLignes];
        }

        if (nombreDeLignes < NB_MAX_LIGNES) {
            lignes[nombreDeLignes++] = new Ligne(Article.getArticle(idArticle), quantityArticle);
            System.out.println("Ligne ajoutée avec succès");
        } else {
            System.out.println("Le nombre de lignes maximum a été atteint");
        }
    }






    public int getPrixTotal() {
        int prixTotal = 0;
        for (Ligne l : lignes) {
            if (l != null && l.article != null) {
                int quantiteAchetee = l.getQuantityBought();
                double prixUnitaire = l.article.getPrice();
                prixTotal += quantiteAchetee * prixUnitaire;
            }
        }
        return prixTotal;
    }


    public void afficherFacture() {
        System.out.println("Facture #" + numeroFacture);
        System.out.println("Client: " + client);
        System.out.println("Date: " + date);
        System.out.println("Articles :");

        System.out.printf("%-6s | %-10s | %-10s | %-10s |  %-10s | %n", "Quantité", "Référence", "Article", "Prix unitaire", "Prix total");

        for (Ligne ligne : lignes) {
            if (ligne != null) {
                ligne.afficheToi();
            }
        }

        System.out.println("Prix total: " + getPrixTotal() + "€");
    }



    @Override
    public String toString() {
        return "Facture{" +
                "articles=" + Arrays.toString(lignes) +
                ", numeroFacture=" + numeroFacture +
                ", client='" + client + '\'' +
                ", date=" + date +
                " Prix total = " + getPrixTotal() + "€" +
                '}';
    }
}
