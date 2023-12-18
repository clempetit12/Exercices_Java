package org.example.exercice_1.service;

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
        try {
            System.out.println("Veuillez saisir le nom de l'étudiant à supprimer : ");
            String lastName = scanner.next();
            System.out.println("Veuillez saisir le prénom de l'étudiant à supprimer : ");
            String firstName = scanner.next();
            String request = "DELETE FROM etudiants WHERE last_name = ? AND first_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, lastName);
            preparedStatement.setString(2, firstName);
            int rows = preparedStatement.executeUpdate();
            System.out.println("Nombre de rangées " + rows);
            preparedStatement.close();
        } catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }

    private static void getAllStudentsFromClass(Connection connection) {
        try {
            System.out.println("Veuillez saisir le numéro de classe : ");
            int nc = scanner.nextInt();
            String request = "SELECT * FROM etudiants WHERE numero_classe = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, nc);
ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ") " + resultSet.getString("last_name") + " , "
                        + resultSet.getString("first_name") + " " + resultSet.getInt("numero_classe") + " " + resultSet.getString("date_diplome"));
            }
        preparedStatement.close();
    } catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }


}

    private static void getAllStudents(Connection connection) {
        try {
            String request = "SELECT * FROM etudiants";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ") " + resultSet.getString("last_name") + " , "
                        + resultSet.getString("first_name") + " " + resultSet.getInt("numero_classe") + " " + resultSet.getString("date_diplome"));
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addStudent(Connection connection) {
        try {
            System.out.println("Veuillez saisir le nom d'un étudiant : ");
            String lastName = scanner.next();
            System.out.println("Veuillez saisir le prénom d'un étudiant : ");
            String firstName = scanner.next();
            System.out.println("Veuillez saisir le numéro de classe d'un étudiant : ");
            int numeroClasse = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Veuillez saisir la date de diplôme d'un étudiant en format YYYY-MM-DD : ");
            String dateDiplome = scanner.nextLine();

            String request = "INSERT INTO etudiants (last_name, first_name, numero_classe, date_diplome) VALUES (? , ? , ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, lastName);
            preparedStatement.setString(2, firstName);
            preparedStatement.setInt(3, numeroClasse);
            preparedStatement.setString(4, dateDiplome);
            int nbRows = preparedStatement.executeUpdate(); // retour int pour récupérer nombre de lignes
            System.out.println("Nombre de lignes " + nbRows);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}




