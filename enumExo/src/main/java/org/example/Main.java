package org.example;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String typeMessage;


        System.out.println("Veuillez entrer le type de message : ");
        typeMessage = scanner.nextLine().toUpperCase();
        while (!typeMessage.equals("A") && !typeMessage.equals("B") && !typeMessage.equals("C") && !typeMessage.equals("D")) {
            System.out.println("Incorrect, veuillez entrer le type de message : ");
            typeMessage = scanner.nextLine().toUpperCase();
        }
        TpeMessage tpeMessage = TpeMessage.valueOf(typeMessage);
        Priority priority = Priority.getPriority(tpeMessage);

        System.out.println("La priorité est :" + priority);


    }
}