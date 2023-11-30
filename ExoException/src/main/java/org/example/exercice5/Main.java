package org.example.exercice5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

try {
    int somme = 0;

    ArrayList<Integer> tabEntiers = new ArrayList<>();
    System.out.println("Saisir un nombre : ");
    int valeur1 =Integer.parseInt(scanner.nextLine()) ;
    System.out.println("Saisir un nombre : ");
    int valeur2 = Integer.parseInt(scanner.nextLine()) ;
    System.out.println("Saisir un nombre : ");
    int valeur3 = Integer.parseInt(scanner.nextLine()) ;
    System.out.println("Saisir un nombre : ");
    int valeur4 = Integer.parseInt(scanner.nextLine()) ;
    tabEntiers.add(valeur1);
    tabEntiers.add(valeur2);
    tabEntiers.add(valeur3);
    tabEntiers.add(valeur4);

    System.out.println("Chaque élément de la liste");
    for (Integer el : tabEntiers) {
        System.out.println(el);
        somme += el;

    }
    System.out.println("La somme des éléments du tableau est :" + somme);

}catch (NumberFormatException e) {
        System.out.println("Exception : " + e.getMessage());}

catch (InputMismatchException e) {
    System.out.println("Vous n'avez pas saisi un entier !");
}

    }
}


