package org.example.view;

import org.example.controller.EmployeeController;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;
import org.example.model.Role;
import org.example.view.dialog.AddDialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeeUI extends JFrame {

    private JPanel jPanel;

    public EmployeeUI() {

        jPanel = new JPanel();
        setTitle("Gestion des Salariés");
        setBounds(100, 100, 350, 200);
        getContentPane().setLayout(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        getContentPane().add(jPanel, BorderLayout.CENTER);
        jPanel.setLayout(null);

        String[] columnNames = {"ID", "Nom", "Prénom","Rôle"};
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employees = employeeDAO.display();
        Object[][] data = new Object[employees.size()][4];
        for (int i = 0; i < employees.size(); i++) {
            Employee contact = employees.get(i);
            data[i][0] = contact.getId();
            data[i][1] = contact.getFirstName();
            data[i][2] = contact.getLastName();
            data[i][3] = contact.getRole();
        }

        JTable table = new JTable(data, columnNames);
        table.setBounds(100, 100, 500, 300);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);


        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        JButton add = new JButton("Ajouter");
        JButton modify = new JButton("Modifier");
        JButton delete = new JButton("Supprimer");
        JButton department = new JButton("Departement");

        jPanelButton.add(add);


        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDialog dialog = new AddDialog();
                dialog.setLocationRelativeTo(jPanel);
                dialog.setVisible(true);
            }
        });



        jPanelButton.add(modify);
        jPanelButton.add(delete);
        jPanelButton.add(department);
    }


}
