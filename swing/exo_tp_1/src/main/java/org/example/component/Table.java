package org.example.component;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.User;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

@Getter
@Setter
public class Table {

    private ArrayList users = new ArrayList<>();
    private JPanel panel;
    private JTextField inputName;
    private JTextField inputEmail;
    private JLabel title;
    private JLabel name;
    private JLabel email;
    private JLabel gendra;
    JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel tableModel;


    public Table( ) {
        initializePanel();
    }

    private void initializePanel() {



        panel = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Tableau de données");
        panel.setBorder(titledBorder);
        tableModel =new DefaultTableModel();
        tableModel.addColumn("Nom");
        tableModel.addColumn("Email");
        tableModel.addColumn("Genre");
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        String name = (String) tableModel.getValueAt(selectedRow, 0);
                        String email = (String) tableModel.getValueAt(selectedRow, 1);
                        String gender = (String) tableModel.getValueAt(selectedRow, 2);
                        System.out.println("Nom: " + name + ", Email: " + email + ", Genre: " + gender);
                        showUserDetailsDialog(name, email, gender);
                    }
                }
            }
        });

        panel.add(scrollPane);
    }

    private void showUserDetailsDialog(String name, String email, String gender) {
        JOptionPane.showMessageDialog(panel, "Nom: " + name + "\nEmail: " + email + "\nGenre: " + gender, "Détails de l'utilisateur", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addUser(User user) {
        tableModel.addRow(new Object[]{user.getName(), user.getEmail(), user.getGendra()});

    }


}







