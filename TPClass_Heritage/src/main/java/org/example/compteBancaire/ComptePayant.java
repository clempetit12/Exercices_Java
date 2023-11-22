package org.example.compteBancaire;

public class ComptePayant extends Compte {


    float facture;

    public ComptePayant( float solde) {
        super(solde);
        this.facture = 0.05f;
    }

    public void retraitComptePayant (int montant) {
        float operation = getSolde()-montant;
        float total =operation- (facture*operation);
        setSolde(total);
        System.out.println("Le solde est à " + total);

    }

    public void versementComptePayant (int montant) {
        float operation = getSolde()+montant;
        float total =operation- facture*operation;
        setSolde(total);
        System.out.println("Le solde est à " + total);
    }


}
