package org.example.compteBancaire;

public class CompteEpargne extends  Compte {

    private float tauxInteret;

    public CompteEpargne(int solde, float tauxInteret) {
        super( solde);
        this.tauxInteret = tauxInteret;
    }

    public float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public void calculInteret() {

        float nouveauSolde = getSolde()*(1+tauxInteret);
        setSolde(nouveauSolde);
        System.out.println("Le nouveau solde est de : " + getSolde());
    }
}
