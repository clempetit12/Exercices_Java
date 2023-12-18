package org.example;

public class Chambre {

    private double numeroChambre;
    private StatutChambre statutChambre;
    private int tarif;
    private int capacity;

    public Chambre(double numeroChambre, StatutChambre statutChambre, int tarif, int capacity) {
        this.numeroChambre = numeroChambre;
        this.statutChambre = statutChambre;
        this.tarif = tarif;
        this.capacity = capacity;
    }

    public double getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public StatutChambre getStatutChambre() {
        return statutChambre;
    }

    public void setStatutChambre(StatutChambre statutChambre) {
        this.statutChambre = statutChambre;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Chambre{" +
                "numeroChambre=" + numeroChambre +
                ", statutChambre=" + statutChambre +
                ", tarif=" + tarif +
                ", capacity=" + capacity +
                '}';
    }
}
