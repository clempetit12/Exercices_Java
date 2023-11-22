package org.example.compteBancaire;

public class CompteEpargne extends  Compte {

    private float tauxInteret;

    public CompteEpargne(int id, int solde, int tauxInteret) {
        super(id, solde);
        this.tauxInteret = tauxInteret;
    }

    public void calculInteret() {
        float nouveauSolde = getSolde()*(1+tauxInteret);
    }
}
