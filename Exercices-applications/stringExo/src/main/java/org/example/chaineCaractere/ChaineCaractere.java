package org.example.chaineCaractere;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ChaineCaractere {
    public static Scanner scanner = new Scanner(System.in);

    public static void getComptageMots() {
        String phrase = " Hello World cher, francis. La vie est belle. ";
        //trim enleve l'espace au début et à la fin de la phrase
        String[] mots = phrase.trim().split(" ");
        int nombreMots = mots.length;
        System.out.println("Il y a : " + nombreMots + " mots");


    }

    public static void comptageOccurences() {
        String mot = "saperlipopette";
        String[] lettres = mot.toLowerCase().split("");
        boolean[] compte = new boolean[lettres.length];
        int[] occurences = new int[lettres.length];
        System.out.println(Arrays.toString(lettres));
        System.out.println("Donnez moi la lettre à rechercher : ");
        //scanner pour une lettre
            char letter = scanner.next().toLowerCase().charAt(0);
        for (int i = 0; i < lettres.length; i++) {
            if (!compte[i]) {
                for (int j = i + 1; j < lettres.length; j++) {
                    if (lettres[i].equals(lettres[j])) {
                        occurences[i]++;
                        compte[j] = true;
                    }
                }
                compte[i] = true;
            }
        }
        System.out.println("TabOccurences : ");
        for (int i = 0; i < lettres.length; i++) {
            if (occurences[i] > 0) {
                System.out.println(lettres[i] + " : " + (occurences[i] + 1));
            }
        }


    }

    public static void anagramme() {
        String mot1 = "gare";
        String mot2 = "rage";

        if (mot1.length() == mot2.length()) {
            char[] lettresMot1 = mot1.toCharArray();
            char[] lettresMot2 = mot2.toCharArray();
            Arrays.sort(lettresMot1);
            Arrays.sort(lettresMot2);

            if (Arrays.equals(lettresMot1, lettresMot2)) {
                System.out.printf("Le mot %s et le mot %s sont des anagrammes", mot1, mot2);
            } else {
                System.out.printf("Le mot %s et le mot %s ne sont pas des anagrammes", mot1, mot2);
            }

        } else {
            System.out.printf("Le mot %s et le mot %s ne sont pas des anagrammes", mot1, mot2);
        }



    }

    public static void palindrome() {
        String mot = "maison";
        int longueur = mot.length();
        boolean palindrome = false;
        for (int i = 0; i < longueur / 2; i++) {
            if (mot.charAt(i) == mot.charAt(longueur - 1 - i)) {
                palindrome = true;
                break;
            }

        }

        if (palindrome) {
            System.out.printf("Le mot %s est un palindrome ", mot);
        } else {
            System.out.printf("Le mot %s n'est pas un palindrome ", mot);
        }


    }

    public static void pyramide() {
        int hauteurPyramide;
        System.out.println("Veuillez indiquer la hauteur de la pyramide : ");
        hauteurPyramide = scanner.nextInt();
        for (int i = hauteurPyramide; i >= 0; i--) {
            String[] tabEtoile = new String[hauteurPyramide - i];
            for (int j = 0; j < tabEtoile.length; j++) {
                tabEtoile[j] = "*";
            }
            for (String element : tabEtoile) {
                System.out.print(element);

            }
            System.out.println();
        }
            for (int i2 = 1; i2 <hauteurPyramide ; i2++) {
                String[] tabEtoile2 = new String[hauteurPyramide - i2];
                for (int j2 = 0; j2 < tabEtoile2.length; j2++) {
                    tabEtoile2[j2] = "*";
                }
                for (String element : tabEtoile2) {
                    System.out.print(element);

                }
            System.out.println();
        }







    }
}
