package org.example.component;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.User;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
public class Table {

    private ArrayList users = new ArrayList<>();
    private JPanel panel;
    JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private String gender;
    private String name;
    private String email;



    public Table( ) {
        initializePanel();
    }

    private void initializePanel() {



        panel = new JPanel(new FlowLayout());
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Tableau de données");
        panel.setBorder(titledBorder);
        tableModel =new DefaultTableModel();
        tableModel.addColumn("Nom");
        tableModel.addColumn("Email");
        tableModel.addColumn("Genre");
        table = new JTable(tableModel);

        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(375, 300));
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        name = (String) tableModel.getValueAt(selectedRow, 0);
                        email = (String) tableModel.getValueAt(selectedRow, 1);
                        gender = (String) tableModel.getValueAt(selectedRow, 2);
                        System.out.println("Nom: " + name + ", Email: " + email + ", Genre: " + gender);

                    }
                }
            }
        });


        JButton details = new JButton("Détails");
        details.addActionListener(   e ->    showUserDetailsDialog());
        details.setPreferredSize(new Dimension(375, 30));
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(details);
    }

    private void showUserDetailsDialog() {
        JOptionPane.showMessageDialog(panel, "Nom: " + name + "\nEmail: " + email + "\nGenre: " + gender, "Détails de l'utilisateur", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addUser(User user) {
        tableModel.addRow(new Object[]{user.getName(), user.getEmail(), user.getGendra()});

    }


}







