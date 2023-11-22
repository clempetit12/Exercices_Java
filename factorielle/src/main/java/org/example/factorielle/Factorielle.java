package org.example.factorielle;

public class Factorielle {

    public static long factorielle (int n){
        long resultat;
        if (n == 0) {
            return 1;
        } else  {
            resultat = n*factorielle(n-1);
            return resultat;
        }

    }
}
