package org.example.maison;

public class Person {

    private String nom;
   private Maison maison;

    public Person(String nom, Maison maison) {
        this.nom = nom;
        this.maison = maison;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Maison getMaison() {
        return maison;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }

    public void display() {
        System.out.println("Je m'appelle " + getNom());
        System.out.println(maison);


    }

    @Override
    public String toString() {
        return "Person{" +
                "nom='" + nom + '\'' +
                ", maison=" + maison +
                '}';
    }
}
