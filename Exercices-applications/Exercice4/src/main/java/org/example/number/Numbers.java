package org.example.number;

import java.util.Scanner;

public class Numbers {
    public static void getPositifNegatifNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donnez un nombre : ");
        int nombre = scanner.nextInt();
        if (nombre<0) {
            System.out.println("Le nombre saisi est négatif");
        } else {
            System.out.println("Le nombre saisi est positif");
        }

    }
}
