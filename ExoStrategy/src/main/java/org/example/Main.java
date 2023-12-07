package org.example;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {

            NavigationSystem navigationSystem = new NavigationSystem.NavigationSystemBuilder().destination("Hawai").build();

            int choice;

            do {
                System.out.println("=== Menu ===");
                System.out.println("1. Stratégie de navigation économique");
                System.out.println("2. Stratégie de navigation offRoad");
                System.out.println("3. Stratégie de navigation roadStrategy");
                System.out.println("4. Quitter la navigation");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        navigationSystem.drive(new EconomicStrategy());
                        break;
                    case 2:
                        navigationSystem.drive(new OffRoadStrategy());
                        break;
                    case 3:
                        navigationSystem.drive(new RoadStrategy());
                        break;
                    case 4:
                        scanner.close();
                        break;
                }

            } while (true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}