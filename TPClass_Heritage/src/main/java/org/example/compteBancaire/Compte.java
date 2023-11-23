package org.example.compteBancaire;

public class Compte {

    private int id;
    //mettre solde en double
    private double solde;

    private static int counter = 0;


    public Compte(double solde) {

        this.solde = solde;
        this.id = counter++;

    }

    public int getId() {
        return id;
    }


    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getCounter() {
        return counter;
    }


    public void versement(int montant) {
        solde = solde + montant;
        System.out.println("Le solde est à " + solde);
    }

    public void retrait(int montant) {
        if (montant > solde) System.out.println("Vous n'avez pas assez d'argent");
         else
             solde = solde - montant;
        System.out.println("Le solde est à " + solde);
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", solde=" + solde +
                ", counter=" + counter +
                '}';
    }
}
