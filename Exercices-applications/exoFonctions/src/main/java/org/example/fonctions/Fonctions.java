package org.example.fonctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fonctions {
    public static Scanner scanner = new Scanner(System.in);

    public static void getSolutionExo1() {


        System.out.println("Veuillez entrer des nombres entiers séparés par un espace : ");
        String nombreEntiers = scanner.nextLine();
        String[] tabnombres = nombreEntiers.split(" ");
        System.out.println(Arrays.toString(tabnombres));
        int[] tabnombresConvertis = new int[tabnombres.length];

        for (int i = 0; i < tabnombresConvertis.length; i++) {
            tabnombresConvertis[i] = Integer.parseInt(tabnombres[i]);


        }

        System.out.println(Arrays.toString(tabnombresConvertis));
        System.out.println("Le nombre max du tableau est : " + findMaxIntInArray(tabnombresConvertis));
    }


    public static int findMaxIntInArray(int[] intArray) {
        int max = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > max) {
                max = intArray[i];
            }

        }
        return max;
    }


    public static void getsolutionExo2() {
        int hauteurRectangle;
        int largeurReactangle;
        System.out.println("Veuillez saisir la hauteur du rectangle : ");
        hauteurRectangle = scanner.nextInt();
        System.out.println("Veuillez saisir la largeur du rectangle : ");
        largeurReactangle = scanner.nextInt();
        imprimeRectangle(hauteurRectangle, largeurReactangle);

    }

    public static void imprimeRectangle(int h, int l) {
        String[][] tab = new String[h][l];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (i == 0 || i == h - 1) {
                    tab[i][j] = "*";
                } else if (j == 0 || j == l - 1) {
                    tab[i][j] = "*";
                } else {
                    tab[i][j] = " ";
                }
            }
        }
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j]);
            }
            System.out.println();
        }

    }

    public static void getSolutionExo3() {
        String texte;
        System.out.println("Veuillez saisir du texte : ");
        texte = scanner.nextLine();
        System.out.println(getWordsAmount(texte));

    }

    public static int getWordsAmount(String chainedecaractere) {
        String[] nombreDeMots = chainedecaractere.split(" ");
        int compteur = 0;
        for (String mot : nombreDeMots) {
            compteur++;
        }
        return compteur;
    }

    public static void getSolutionExo4() {
        String mots;
        int longueurMot;
        String[] tabMots;

        System.out.println("Veuillez entrer des mots aléatoires séparés par un espace : ");
        mots = scanner.nextLine();
        System.out.println("Veuillez entrer la longueur minimale de la chaine de caractère : ");
        longueurMot = scanner.nextInt();
        tabMots = mots.split(" ");
        System.out.println(Arrays.toString(tabMots));
        ;
        System.out.println(Arrays.toString(filterWordsByLength(longueurMot, tabMots)));


    }

    public static String[] filterWordsByLength(int minLength, String[] mots) {
        int longueurMot;
        String[] motsSelectionnes = new String[mots.length];
        int index = 0;
        for (String mot : mots) {
            longueurMot = mot.length();
            if (longueurMot >= minLength) {
                motsSelectionnes[index++] = mot;
            } else {
                motsSelectionnes[index++] = " ";
            }
        }
        return motsSelectionnes;
    }

    public static void getSolutionExo6() {
        String chiffres;
        String[] tabChiffresNonConvertis;
        int[] tabChiffres;
        System.out.println("Veuillez entrer deux chiffres séparés par un espace ");
        chiffres = scanner.nextLine();
        tabChiffresNonConvertis = chiffres.split(" ");
        tabChiffres = new int[tabChiffresNonConvertis.length];

        for (int i = 0; i < tabChiffres.length; i++) {
            tabChiffres[i] = Integer.parseInt(tabChiffresNonConvertis[i]);


        }
        System.out.println(Arrays.toString(tabChiffres));
        int firstNumber = tabChiffres[0];
        int secondNumber = tabChiffres[1];
        System.out.println(gcdRecursive(firstNumber, secondNumber));

    }

    public static int[] gcdRecursive(int firstNumber, int secondNumber) {
        List<Integer> diviseurFirstNumber = getDivisors(firstNumber);
        List<Integer> diviseurSecondNumber = getDivisors(secondNumber);






        for (int i = 1; i < secondNumber; i++) {
            if (secondNumber % i == 0) {
               diviseurSecondNumber.add(i);
            }


        }




        }

    public static List<Integer> getDivisors (int number) {
        List<Integer> diviseurCommun = new ArrayList<>(number);
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                diviseurCommun.add(i);
            }
        }

    }

    }
}

