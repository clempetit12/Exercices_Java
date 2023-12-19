package org.example.exercice_1.classe;

import org.example.exercice_1.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Etudiant {
    private int id;
    private String lastName;
    private String firstName;
    private int numeroClasse;
    // on aurait pu mettre un Date comme type
    private Date dateDiplome;

    // mettre les éléments réutilisés en static
    public static String request;
    public static Connection connection;
    public static PreparedStatement preparedStatement;

    public Etudiant(int id, String lastName, String firstName, int numeroClasse, Date dateDiplome) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.numeroClasse = numeroClasse;
        this.dateDiplome = dateDiplome;
    }

    public Etudiant(String lastName, String firstName, int numeroClasse, Date dateDiplome) {
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

    public Date getDateDiplome() {
        return dateDiplome;
    }

    public void setDateDiplome(Date dateDiplome) {
        this.dateDiplome = dateDiplome;
    }

    public boolean addStudents() throws SQLException {
        request = "INSERT INTO etudiants (last_name, first_name, numero_classe, date_diplome) VALUES (? , ? , ?, ?)";
        connection = ConnectionUtils.getMySQLConnection();
        // retourner l'id
        preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, getLastName());
        preparedStatement.setString(2, getFirstName());
        preparedStatement.setInt(3, getNumeroClasse());
        preparedStatement.setDate(4, new java.sql.Date(getDateDiplome().getTime()));
        int nbRows = preparedStatement.executeUpdate(); // retour int pour récupérer nombre de lignes
        System.out.println("Nombre de lignes " + nbRows);
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            setId(resultSet.getInt("id"));
        }
        preparedStatement.close();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nbRows > 0;

    }

    public static List<Etudiant> getListStudents() throws SQLException {
        List<Etudiant> result = new ArrayList<>();
        request = "SELECT * FROM etudiants";
        connection = ConnectionUtils.getMySQLConnection();
        preparedStatement = connection.prepareStatement(request);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Etudiant e = new Etudiant(resultSet.getInt("id"), resultSet.getString("last_name"), resultSet.getString("first_name"), resultSet.getInt("numero_classe"), resultSet.getDate("date_diplome"));
            result.add(e);
        }
            preparedStatement.close();
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        return result;}


    public static List<Etudiant> getStudentsFromClass(int nc) throws SQLException {
        List<Etudiant> result = new ArrayList<>();
        request = "SELECT * FROM etudiants WHERE numero_classe = ?";
        connection = ConnectionUtils.getMySQLConnection();
        preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, nc);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Etudiant e = new Etudiant(resultSet.getInt("id"), resultSet.getString("last_name"), resultSet.getString("first_name"), resultSet.getInt("numero_classe"), resultSet.getDate("date_diplome"));
            result.add(e);
        }
        preparedStatement.close();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

        public boolean deleteStudents () throws SQLException {

            request = "DELETE FROM etudiants WHERE id = ?";
            connection = ConnectionUtils.getMySQLConnection();
            preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, getId());
            int rows = preparedStatement.executeUpdate();
            System.out.println("Nombre de rangées " + rows);
            preparedStatement.close();
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                return rows > 0;

    }

    public static Etudiant getStudentId(int id) throws SQLException {
        Etudiant etudiant = null;
        request = "SELECT * FROM etudiants WHERE id = ? ";
        connection = ConnectionUtils.getMySQLConnection();
        preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            etudiant = new Etudiant(resultSet.getInt("id"), resultSet.getString("last_name"), resultSet.getString("first_name"), resultSet.getInt("numero_classe"), resultSet.getDate("date_diplome"));
        }
        preparedStatement.close();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return etudiant;
    }

    public static void searchStudentByName(String lastName, String firstName) {
        try {
            request = "SELECT * FROM etudiants WHERE last_name = ? AND first_name = ?";
            connection = ConnectionUtils.getMySQLConnection();
            preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, lastName);
            preparedStatement.setString(2, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("requête ok");
                System.out.println(resultSet.getInt("id") + ") " + resultSet.getString("last_name") + " , "
                        + resultSet.getString("first_name") + " " + resultSet.getInt("numero_classe") + " " + resultSet.getString("date_diplome"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", numeroClasse=" + numeroClasse +
                ", dateDiplome=" + dateDiplome +
                '}';
    }
}
