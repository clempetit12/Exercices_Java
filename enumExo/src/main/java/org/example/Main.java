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
            typeMessage = scanner.nextLine();
        }
      Priority priority = Priority.getPriority(typeMessage);

        System.out.println("La priorité est :" + priority);


    }
}