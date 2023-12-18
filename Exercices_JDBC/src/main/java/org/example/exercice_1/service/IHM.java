package org.example.exercice_1.service;

import org.example.exercice_1.classe.Etudiant;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IHM {
    public static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println("Gestion étudiants");
        printMenu();
    }


    public static void printMenu() {
        int choix;

        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher tous les étudiants");
            System.out.println("3. Afficher tous les étudiants d'une classe");
            System.out.println("4. Supprimer un etudiant");
            System.out.println("5. Chercher un étudiant");

            System.out.println("Sélectionner votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    getAllStudents();
                    break;
                case 3:
                    getAllStudentsFromClass();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchByName();
                    break;
                case 0:
                    scanner.close();
                    break;

            }
            System.out.println();
        } while (choix != 0);

    }

    private static void searchByName() {
        System.out.println("Veuillez saisir le nom de l'étudiant que vous recherchez : ");
        String lastName = scanner.next();
        System.out.println("Veuillez saisir le prénom de l'étudiant que vous recherchez : ");
        String firstName = scanner.next();
        Etudiant.searchStudentByName(lastName,firstName);

    }



    private static void deleteStudent()  {
        System.out.println("Veuillez saisir le nom de l'étudiant à supprimer : ");
        String lastName = scanner.next();
        System.out.println("Veuillez saisir le prénom de l'étudiant à supprimer : ");
        String firstName = scanner.next();
        int studentId = Etudiant.getStudentId(firstName,lastName);
        Etudiant.deleteStudents(studentId);
    }

    private static void getAllStudentsFromClass() {
        System.out.println("Veuillez saisir le numéro de classe : ");
        int nc = scanner.nextInt();
        Etudiant.getStudentsFromClass(nc);


    }

    private static void getAllStudents() {
        Etudiant.getListStudents();
    }

    private static void addStudent() {
        System.out.println("Veuillez saisir le nom d'un étudiant : ");
        String lastName = scanner.next();
        System.out.println("Veuillez saisir le prénom d'un étudiant : ");
        String firstName = scanner.next();
        System.out.println("Veuillez saisir le numéro de classe d'un étudiant : ");
        int numeroClasse = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Veuillez saisir la date de diplôme d'un étudiant en format YYYY-MM-DD : ");
        String dateDiplome = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date diplomeDate = dateFormat.parse(dateDiplome);
            System.out.println("Date de diplôme convertie en objet Date : " + diplomeDate);
            Etudiant etudiant = new Etudiant(lastName,firstName,numeroClasse, (java.sql.Date) diplomeDate);
            etudiant.addStudents();
        } catch (ParseException e) {
            System.out.println("Format de date invalide. Assurez-vous d'utiliser le format YYYY-MM-DD.");
            e.printStackTrace(); // Vous pouvez gérer cette exception selon vos besoins.
        }




    }
}




