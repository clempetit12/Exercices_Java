package org.example.view.dialog;

import org.example.controller.EmployeeController;
import org.example.model.Employee;
import org.example.model.Role;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDialog extends JDialog {
    private int employeeId;
    private String firstName;
    private String lastName;
    private Role role;

    private JPanel contentPanel;
    private JTextField lastNameField;

    public UpdateDialog(int employeeId, String firstName, String lastName, Role role) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;



        contentPanel = new JPanel();
        setTitle("Modifier un salarié");
        setBounds(100, 100, 600, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel labelLastName = new JLabel("Nom:");
        labelLastName.setBounds(10, 20, 50, 15);
        contentPanel.add(labelLastName);

        lastNameField = new JTextField(lastName);
        lastNameField.setBounds(250, 20, 250, 20);
        contentPanel.add(lastNameField);
        lastNameField.setColumns(20);


        JLabel labelRole = new JLabel("Role");
        labelRole.setBounds(10, 60, 50, 15);
        contentPanel.add(labelRole);

        JComboBox<Role> roleComboBox = new JComboBox<>(Role.values());
        roleComboBox.setBounds(250, 60, 150, 20);


        contentPanel.add(roleComboBox);


        if (roleComboBox.getItemCount() > 0) {
            roleComboBox.setSelectedIndex(0);
        }


        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        JButton jButton = new JButton("Modifier");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EmployeeController employeeController = new EmployeeController();
                System.out.println("id"+employeeId);
                Employee employee = employeeController.searchEmployee(employeeId);
                System.out.println(employee);
                employee.setLastName(lastNameField.getText());
                Role selectedRole = (Role) roleComboBox.getSelectedItem();
               employee.setRole(selectedRole);
                if (employeeController.updateEmployee(employeeId,employee)) {
                    JOptionPane.showConfirmDialog(null, "Operation succeed");
                } else {
                    JOptionPane.showConfirmDialog(null, "Operation Failed");
                }
                dispose();
            }
        });
        jPanelButton.add(jButton);


    }






}
