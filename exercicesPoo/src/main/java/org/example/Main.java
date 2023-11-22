package org.example;

import org.example.chaise.Chaise;

public class Main {
    public static void main(String[] args) {
        Chaise chaise1 = new Chaise(4, "bleu", "Bois");
        Chaise chaise2 = new Chaise(4, "blanche", "métal");
        Chaise chaise3 = new Chaise(1, "transparent", "plexiglas");
        affichage(chaise1);
        affichage(chaise2);
        affichage(chaise3);
    }

    public static void affichage(Object chaise) {
        System.out.println(chaise);
    }


}

