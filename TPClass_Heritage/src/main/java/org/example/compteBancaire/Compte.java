package org.example.compteBancaire;

public class Compte  {

    private int id;
    private int solde;

    int counter;

    public Compte(int id, int solde) {
        this.id = counter++;
        this.solde = solde;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void versement( int montant) {
int total = solde+montant;
        System.out.println("Le solde est à " + total);
    }

    public void retrait( int montant) {
        int total = solde-montant;
        System.out.println("Le solde est à " + total);
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
