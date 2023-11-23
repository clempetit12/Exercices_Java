package org.example.compteBancaire;

public class ComptePayant extends Compte {


    float facture;
    private int id;

    public ComptePayant( float solde) {
        super(solde);
        this.facture = 0.05f;
        this.id=getCounter();
    }

    public void retraitComptePayant (int montant) {
        double operation = getSolde()-montant;
        double total =operation- (facture*operation);
        setSolde(total);
        System.out.println("Le solde est à " + total);

    }

    public void versementComptePayant (int montant) {
        double operation = getSolde()+montant;
        double total =operation- facture*operation;
        setSolde(total);
        System.out.println("Le solde est à " + total);
    }


}
