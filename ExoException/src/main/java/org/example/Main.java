package org.example;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {

            System.out.println("Veuillez saisir une chaîne de caractère : ");
            String chaineCaractere = scanner.next();
            int chainEnChiffre  = Integer.parseInt(chaineCaractere);
            System.out.println("La chaine de caractère convertie en entier est :" + chainEnChiffre);

        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch(ExerciceException e){
            System.out.println("Une exception est apparue !");
        }
        System.out.println("Fin du programme !");
    }

}
