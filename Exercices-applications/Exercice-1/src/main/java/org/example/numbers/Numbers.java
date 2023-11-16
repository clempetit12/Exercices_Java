package org.example.numbers;

import java.util.Scanner;

public class Numbers {
    public static void getNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donnez un nombre : ");
        Integer nombre = scanner.nextInt();

        System.out.println("Le nombre saisi est " + (nombre*nombre));
    }
}
