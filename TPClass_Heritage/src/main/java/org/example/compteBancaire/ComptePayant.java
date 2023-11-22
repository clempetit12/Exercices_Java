package org.example.compteBancaire;

public class ComptePayant extends Compte {


    float facture;

    public ComptePayant(int id, int solde, int facture) {
        super(id, solde);
        this.facture = 0.05f;
    }

    public void retraitComptePayant (int montant) {
        int operation = getSolde()-montant;
        float total =operation- facture*operation;
        System.out.println("Le solde est à " + total);

    }

    public void versementComptePayant (int montant) {
        int operation = getSolde()+montant;
        float total =operation- facture*operation;
        System.out.println("Le solde est à " + total);
    }


}
