package org.example.exercice_1.service;

import org.example.exercice_1.classe.Etudiant;

import java.sql.*;
import java.util.Scanner;

public class IHM {
    public static Scanner scanner = new Scanner(System.in);

    public static void start(Connection connection) {
        System.out.println("Gestion étudiants");
        printMenu(connection);
    }


    public static void printMenu(Connection connection) {
        int choix;

        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher tous les étudiants");
            System.out.println("3. Afficher tous les étudiants d'une classe");
            System.out.println("4. Supprimer un etudiant");

            System.out.println("Sélectionner votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    addStudent(connection);
                    break;
                case 2:
                    getAllStudents(connection);
                    break;
                case 3:
                    getAllStudentsFromClass(connection);
                    break;
                case 4:
                    deleteStudent(connection);
                    break;
                case 0:
                    scanner.close();
                    break;

            }
            System.out.println();
        } while (choix != 0);

    }


    private static void deleteStudent(Connection connection) {
        System.out.println("Veuillez saisir le nom de l'étudiant à supprimer : ");
        String lastName = scanner.next();
        System.out.println("Veuillez saisir le prénom de l'étudiant à supprimer : ");
        String firstName = scanner.next();
        int studentId = Etudiant.getStudentId(firstName,lastName,connection);
        Etudiant.deleteStudents(studentId, connection);
    }

    private static void getAllStudentsFromClass(Connection connection) {
        System.out.println("Veuillez saisir le numéro de classe : ");
        int nc = scanner.nextInt();
        Etudiant.getStudentsFromClass(nc, connection);


    }

    private static void getAllStudents(Connection connection) {
        Etudiant.getListStudents(connection);
    }

    private static void addStudent(Connection connection) {
        System.out.println("Veuillez saisir le nom d'un étudiant : ");
        String lastName = scanner.next();
        System.out.println("Veuillez saisir le prénom d'un étudiant : ");
        String firstName = scanner.next();
        System.out.println("Veuillez saisir le numéro de classe d'un étudiant : ");
        int numeroClasse = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Veuillez saisir la date de diplôme d'un étudiant en format YYYY-MM-DD : ");
        String dateDiplome = scanner.nextLine();
        Etudiant.addStudents(lastName, firstName, numeroClasse, dateDiplome, connection);

    }
}




