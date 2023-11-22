package org.example.compteBancaire;

public class CompteSimple extends Compte {

    int decouvert;

    public CompteSimple(int id, int solde, int decouvert) {
        super(id, solde);
        this.decouvert = decouvert;
    }

    public int getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(int decouvert) {
        this.decouvert = decouvert;
    }

    public void retrait( int montant) {
        if(montant>decouvert) {
            System.out.println("Vous ne pouvez pas retirer");
        } else {
            retrait(montant);
        }


    }
}
