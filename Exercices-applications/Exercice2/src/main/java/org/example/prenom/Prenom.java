package org.example.prenom;

import java.util.Scanner;

public class Prenom {
    public static void getprenom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est votre prénom ? :");
String prenom = scanner.next();;
        System.out.println(" Bonjour " + prenom);


    }
}
