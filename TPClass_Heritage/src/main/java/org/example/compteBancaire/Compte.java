package org.example.compteBancaire;

public class Compte  {

    private int id;
    private float solde;
    private static int counter = 0;


    public Compte( float solde) {

        this.solde = solde;
        this.id = counter++;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void versement( int montant) {
float total = solde+montant;
        System.out.println("Le solde est à " + total);
    }

    public void retrait( int montant) {
        float total = solde-montant;
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
