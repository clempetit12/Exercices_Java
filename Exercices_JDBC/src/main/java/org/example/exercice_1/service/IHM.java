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
            menu();
            System.out.println("Sélectionner votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();
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
        Etudiant.searchStudentByName(lastName, firstName);

    }


    private static void deleteStudent() {
        System.out.println("Veuillez saisir l'id étudiant à supprimer : ");
        int idEtudiant = scanner.nextInt();
        scanner.nextLine();
        try {
            Etudiant etudiant = Etudiant.getStudentId(idEtudiant);
            etudiant.deleteStudents();
            if (etudiant != null) {
                if (etudiant.deleteStudents()) {
                    System.out.println("Étudiant supprimé");
                } else {
                    System.out.println("Erreur lors de la suppression de l'étudiant");
                }
            } else {
                System.out.println("Pas d'étudiant avec cet id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    private static void getAllStudentsFromClass(){
        try{
        System.out.println("Veuillez saisir le numéro de classe : ");
        int nc=scanner.nextInt();
        Etudiant.getStudentsFromClass(nc).forEach(e->System.out.println(e));
        }catch(SQLException e){
        System.out.println(e.getMessage());
        }
        }

private static void getAllStudents(){
        try{
        Etudiant.getListStudents().forEach(e->System.out.println(e));
        }catch(SQLException e){
        System.out.println(e.getMessage());
        }
        }

private static void addStudent(){
        System.out.println("Veuillez saisir le nom d'un étudiant : ");
        String lastName=scanner.nextLine();
        System.out.println("Veuillez saisir le prénom d'un étudiant : ");
        String firstName=scanner.nextLine();
        System.out.println("Veuillez saisir le numéro de classe d'un étudiant : ");
        int numeroClasse=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Veuillez saisir la date de diplôme d'un étudiant en format dd-mm-yyyy : ");
        String dateDiplome=scanner.nextLine();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
        Date diplomeDate=null;
        try{
        diplomeDate=dateFormat.parse(dateDiplome);
        }catch(ParseException e){
        diplomeDate=new Date("01/01/2005");
        }
        Etudiant etudiant=new Etudiant(lastName,firstName,numeroClasse,diplomeDate);
        try{
        etudiant.addStudents();
        if(etudiant.addStudents()){
        System.out.println("Etudiant ajouté avec succès "+etudiant.getId());
        }else{
        System.out.println("Erreur ajout etudiant");
        }

        }catch(SQLException e){
        System.out.println(e.getMessage());
        }
        }

private static void menu(){
        System.out.println("=== Menu ===");
        System.out.println("1. Ajouter un étudiant");
        System.out.println("2. Afficher tous les étudiants");
        System.out.println("3. Afficher tous les étudiants d'une classe");
        System.out.println("4. Supprimer un etudiant");
        System.out.println("5. Chercher un étudiant");


        }
        }




