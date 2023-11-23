package org.example.compteBancaire;

public class CompteSimple extends Compte {

    int decouvert;
    private int id;

    public CompteSimple( int solde, int decouvert) {
        super( solde);
        this.decouvert = decouvert;
        this.id = getCounter();
    }

    public int getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(int decouvert) {
        this.decouvert = decouvert;
    }

    public void retrait( int montant) {
        if(getSolde()-montant<decouvert) {
            System.out.println("Vous ne pouvez pas retirer");
        } else {
            super.retrait(montant);
            double nouveauSolde = getSolde() - montant;
            setSolde(nouveauSolde);
        }


    }
}
