package org.example.view.dialog;

import org.example.controller.DepartmentController;
import org.example.controller.EmployeeController;
import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.Role;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddDialog extends JDialog {

    private JPanel contentPanel;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField role;
    private ButtonGroup radioButtonGroup;
    private int  selectedDepartmentId;

    public AddDialog() {

    contentPanel = new JPanel();
    setTitle("Insertion Contact");
    setBounds(100, 100, 600, 300);
    getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

    JLabel labelLastName = new JLabel("Nom:");
        labelLastName.setBounds(10, 20, 50, 15);
        contentPanel.add(labelLastName);

    lastName = new JTextField();
        lastName.setBounds(250, 20, 250, 20);
        contentPanel.add(lastName);
        lastName.setColumns(20);


    JLabel labelFirstName = new JLabel("Prénom");
        labelFirstName.setBounds(10, 40, 50, 15);
        contentPanel.add(labelFirstName);

    firstName = new JTextField();
        firstName.setBounds(250, 40, 250, 20);
        contentPanel.add(firstName);
        firstName.setColumns(10);

    JLabel labelRole = new JLabel("Role");
        labelRole.setBounds(10, 60, 50, 15);
        contentPanel.add(labelRole);

    radioButtonGroup = new ButtonGroup();

    JRadioButton manager = new JRadioButton(String.valueOf(Role.MANAGER));
        manager.setBounds(250, 60, 150, 20);

    JRadioButton employeeButton = new JRadioButton(String.valueOf(Role.EMPLOYEE));
        employeeButton.setBounds(350, 60, 150, 20);

    JRadioButton rh = new JRadioButton(String.valueOf(Role.RH));
        rh.setBounds(450, 60, 150, 20);
        radioButtonGroup.add(manager);
        radioButtonGroup.add(employeeButton);
        radioButtonGroup.add(rh);

        contentPanel.add(manager);
        contentPanel.add(employeeButton);
        contentPanel.add(rh);


    JLabel labelDepartment = new JLabel("Department");
        labelDepartment.setBounds(10, 80, 50, 15);
        contentPanel.add(labelDepartment);


        DepartmentController departmentController = new DepartmentController();

        List<Department> departments = departmentController.displayAll();

        String[] departmentNames = new String[departments.size()];
        for (int i = 0; i < departments.size(); i++) {
            departmentNames[i] = departments.get(i).getName();
        }

        JComboBox<String> departmentComboBox = new JComboBox<>(departmentNames);
        departmentComboBox.setBounds(250, 80, 250, 20);
        contentPanel.add(departmentComboBox);


        departmentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = departmentComboBox.getSelectedIndex();
                if (selectedIndex >= 0 && selectedIndex < departments.size()) {
                    Department selectedDepartment = departments.get(selectedIndex);
                    selectedDepartmentId = selectedDepartment.getId();

                }
            }
        });


    JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new BorderLayout());

    getContentPane().add(jPanelButton, BorderLayout.SOUTH);

    JButton jButton = new JButton("Ajouter");
        jButton.setPreferredSize(new Dimension(jPanelButton.getWidth(), 30));
        jButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        jPanelButton.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanelButton.add(jButton, BorderLayout.CENTER);

        jButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Employee employee = new Employee();
            EmployeeController employeeController = new EmployeeController();
            employee.setFirstName(firstName.getText());
            employee.setLastName(lastName.getText());
            if (manager.isSelected()) {
                employee.setRole(Role.MANAGER);
            } else if (employeeButton.isSelected()) {
                employee.setRole(Role.EMPLOYEE);
            } else if (rh.isSelected()) {
                employee.setRole(Role.RH);
            }
            ;
employee.setId(selectedDepartmentId);
            if (employeeController.createEmployee(employee)) {
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
