package org.example.compteBancaire;

public class Main {
    public static void main(String[] args) {
        CompteEpargne compteEpargne1 = new CompteEpargne(100,0.01f);
      compteEpargne1.getTauxInteret();
      CompteSimple compteSimple = new CompteSimple(200,100);
      compteSimple.retrait(50);
      compteSimple.retrait(100);
      compteSimple.retrait(100);
        compteSimple.retrait(100);
        compteEpargne1.calculInteret();
        ComptePayant comptePayant = new ComptePayant(200);
        comptePayant.retraitComptePayant(50);
        comptePayant.versementComptePayant(100);
    }



}
