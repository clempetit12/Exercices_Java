package org.example.exercice_1;

import java.sql.*;

public class Etudiant {
   private int id;
   private String lastName;
   private String firstName;
   private int numeroClasse;
   private String dateDiplome;

    public Etudiant(int id, String lastName, String firstName, int numeroClasse, String dateDiplome) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.numeroClasse = numeroClasse;
        this.dateDiplome = dateDiplome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getNumeroClasse() {
        return numeroClasse;
    }

    public void setNumeroClasse(int numeroClasse) {
        this.numeroClasse = numeroClasse;
    }

    public String getDateDiplome() {
        return dateDiplome;
    }

    public void setDateDiplome(String dateDiplome) {
        this.dateDiplome = dateDiplome;
    }

    public static void addStudents(String lastName, String firstName, int numeroClasse, String dateDiplome, Connection connection) {
        try{
        String request = "INSERT INTO etudiants (last_name, first_name, numero_classe, date_diplome) VALUES (? , ? , ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setString(1, lastName);
        preparedStatement.setString(2, firstName);
        preparedStatement.setInt(3, numeroClasse);
        preparedStatement.setString(4, dateDiplome);
        int nbRows = preparedStatement.executeUpdate(); // retour int pour récupérer nombre de lignes
        System.out.println("Nombre de lignes " + nbRows);

    }catch (SQLException e) {
            System.out.println(e.getMessage());
        }}

    public static void getListStudents (Connection connection) {
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

    public static void getStudentsFromClass(int nc, Connection connection) {
        try {

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

    public static void deleteStudents(String firstName, String lastName, Connection connection) {
        try {

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
}
