package org.example.compteBancaire;

public class CompteSimple extends Compte {

    int decouvert;

    public CompteSimple( int solde, int decouvert) {
        super( solde);
        this.decouvert = decouvert;
    }

    public int getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(int decouvert) {
        this.decouvert = decouvert;
    }

    public void retrait( int montant) {
        if(getSolde()<decouvert) {
            System.out.println("Vous ne pouvez pas retirer");
        } else {
            super.retrait(montant);
            float nouveauSolde = getSolde() - montant;
            setSolde(nouveauSolde);
        }


    }
}
