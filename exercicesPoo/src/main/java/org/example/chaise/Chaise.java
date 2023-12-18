package org.example.chaise;

public class Chaise {

    private int nombrePieds;
    private String couleur,materiaux;

    public Chaise() {
    }

    public Chaise(int nombrePieds, String couleur, String materiaux) {
        this.nombrePieds = nombrePieds;
        this.couleur = couleur;
        this.materiaux = materiaux;
    }

    public int getNombrePieds() {
        return nombrePieds;
    }

    public void setNombrePieds(int nombrePieds) {
        this.nombrePieds = nombrePieds;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(String materiaux) {
        this.materiaux = materiaux;
    }

    @Override
    public String toString() {
        return " -------Affichage d'un nouvel objet ------- \n" +
                "Je suis une chaise, avec " + nombrePieds +
                " pieds en " + materiaux + " et de couleur " + couleur +"\n" +
                "----------------------------------------------";

    }
}
