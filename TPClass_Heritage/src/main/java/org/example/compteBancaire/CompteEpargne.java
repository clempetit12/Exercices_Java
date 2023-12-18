package org.example.compteBancaire;

public class CompteEpargne extends  Compte {

    private double tauxInteret;
    private int id;

    public CompteEpargne(float solde, double tauxInteret) {
        super(solde);
        this.tauxInteret = tauxInteret;
        this.id = getCounter();
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public void calculInteret() {

        double nouveauSolde = getSolde()*(1+tauxInteret);
        setSolde(nouveauSolde);
        System.out.println("Le nouveau solde est de : " + getSolde());
    }
}
