package org.example.prixArticle;

public class PrixArticle {
    public static void getprixArticle() {
        int prixHT = 20;
        int nombreArticles = 10;
        float tauxTVA = 0.10f;
        System.out.println("Prix HT : " + prixHT);
        System.out.println("Nombre articles : " + nombreArticles);
        System.out.println("Taux TVA : " + tauxTVA);
        float prixTotalHT = nombreArticles * prixHT;
        float prixTTC = prixTotalHT * (1 + tauxTVA);
        System.out.println("Le prix total est de " + prixTTC);





    }
}
