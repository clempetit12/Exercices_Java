package org.example.tableau;

public class Tableau {
    public static void getSolution55() {
        int[] tab = {1, 2, 3, 4, 5, 6};
        int valeur;

        for (int i = 0; i < tab.length / 2; i++) {
            if (tab[i] != tab[(tab.length - 1) - i]) {
                valeur = tab[i];
                tab[i] = tab[(tab.length - 1) - i];
                tab[(tab.length - 1) - i] = valeur;
            }
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }

    public static void getSolution56() {
        int[] tab = {12, 8, 24, 5, 16, 90};
        int valeur;
        for (int i = 0; i < tab.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] < tab[i]) {
                    min = j;
                }
                valeur = tab[i];
                tab[i] = tab[min];
                tab[min] = valeur;
            }

        }
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }

    public static void getSolution57() {
        int[] tab = {12, 8, 24, 5, 16, 90};
        int valeur;
        for (int i = 0; i < tab.length - 1; i++) {
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[i] > tab[j]) {
                    valeur = tab[j];
                    tab[j] = tab[i];
                    tab[i] = valeur;
                }
            }

        }
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }

    public static void getSolution58() {
        int[] t1 = {6,7,8};
        int[] t2 = {5,4,2};

        if ((t2.length == t1.length) && (t1.length>0 & t2.length>0)) {
            System.out.println("Les tableaux sont de même dimensions. \n  ");
            for (int i = 0; i < t1.length; i++) {
                int[] t3 = new int[t1.length];
                t3[i] = t2[i] + t1[i];
                System.out.println("La somme est la suivante : " + t3[i]);

            }
        }
        else {
            System.out.println("Les tableaux n'ont pas la même dimension ou ne sont pas réguliers");
        }

    }

}
