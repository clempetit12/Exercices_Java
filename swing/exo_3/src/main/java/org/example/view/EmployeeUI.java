package org.example.view;

import org.example.controller.DepartmentController;
import org.example.controller.EmployeeController;

import org.example.dao.EmployeeDAO;
import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.Role;
import org.example.view.dialog.AddDialog;
import org.example.view.dialog.UpdateDialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class EmployeeUI extends JFrame {

    private JPanel jPanel;
    private int selectedRowIndex;

    private DefaultTableModel tableModel;

    private String type;
    public static final String EMPLOYEE_ADDED_EVENT = "EmployeeAdded";
    public static final String DEPARTMENT_ADDED_EVENT = "DepartmentAdded";

    private  JTable table;

    private boolean isEmployeeDisplayed = true;
    private List<Employee> data;

    private DepartmentController departmentController = new DepartmentController();

    private EmployeeController employeeController = new EmployeeController();

    public EmployeeUI() {

        jPanel = new JPanel();
        setTitle("Gestion des Salariés");
        setBounds(100, 100, 350, 200);
        getContentPane().setLayout(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        getContentPane().add(jPanel, BorderLayout.CENTER);
        jPanel.setLayout(null);

        showTable();


        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selectedRowIndex = table.getSelectedRow();
                    System.out.println(selectedRowIndex);


                }

            }
        });


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
                if(isEmployeeDisplayed) {
                     type = EMPLOYEE_ADDED_EVENT;
                    System.out.println(type);
                } else {
                    type =DEPARTMENT_ADDED_EVENT;
                    System.out.println(type);
                }
                AddDialog dialog = new AddDialog(type);
                dialog.setLocationRelativeTo(jPanel);
                dialog.setVisible(true);
                dialog.addPropertyChangeListener(AddDialog.EMPLOYEE_ADDED_EVENT, new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        Employee newEmployee = (Employee) evt.getNewValue();
                        Object[] rowData = {newEmployee.getId(), newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getRole()};
                        tableModel.addRow(rowData);
                    }
                });
            }
        });


        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowIndex = table.getSelectedRow();

                if (selectedRowIndex != -1) {
                    if(isEmployeeDisplayed) {
                        type = EMPLOYEE_ADDED_EVENT;
                        int employeeId = (int) table.getValueAt(selectedRowIndex, 0);
                        String firstName = (String) table.getValueAt(selectedRowIndex, 1);
                        String lastName = (String) table.getValueAt(selectedRowIndex, 2);
                        Role role = (Role) table.getValueAt(selectedRowIndex, 3);

                        System.out.println("ID: " + employeeId);
                        System.out.println("Nom: " + firstName);
                        System.out.println("Prénom: " + lastName);
                        System.out.println("Rôle: " + role);

                        UpdateDialog dialog = new UpdateDialog(employeeId, firstName, lastName, role);
                        dialog.setLocationRelativeTo(jPanel);
                        dialog.setVisible(true);
                        dialog.addPropertyChangeListener(AddDialog.EMPLOYEE_ADDED_EVENT, new PropertyChangeListener() {
                            @Override
                            public void propertyChange(PropertyChangeEvent evt) {
                                Employee newEmployee = (Employee) evt.getNewValue();
                                Object[] rowData = {newEmployee.getId(), newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getRole()};
                                tableModel.addRow(rowData);
                            }
                        });

                    } else {
                        type = DEPARTMENT_ADDED_EVENT;
//                        List<Department> departmentList = departmentController.displayAll();
//                        Department selectedDepartment =
//                        if (selectedDepartment != null) {
//                            int departmentId = selectedDepartment.getId();

                        }

                    }






                }

        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRowIndex = table.getSelectedRow();
                if (selectedRowIndex != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    int employeeId = (int) table.getValueAt(selectedRowIndex, 0);
                    employeeController.deleteEmployee(employeeId);
                    model.removeRow(selectedRowIndex);
                }
            }
        });

        department.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isEmployeeDisplayed) {
                    departmentController = new DepartmentController();
                    List<Department>departments = departmentController.displayAll();
                    DefaultListModel<Department> model = new DefaultListModel<>();
                    for (Department department : departments) {
                        model.addElement(department);
                    }
                    JList<Department> departmentJList = new JList<>(model);
                    departmentJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    JScrollPane scrollPane = new JScrollPane(departmentJList);
                    department.setText("Salarié");
                    jPanel.remove(table);
                    add(scrollPane, BorderLayout.CENTER);
                    ((DefaultListModel<Department>) departmentJList.getModel()).clear();
                    for (Department department : departments) {
                        ((DefaultListModel<Department>) departmentJList.getModel()).addElement(department);
                    }
                    department.setText("Salarié");
                    isEmployeeDisplayed = false;
                } else {
                  showTable();
                    department.setText("Département");
                    isEmployeeDisplayed = true;
                    jPanel.repaint();
                    jPanel.revalidate();
                }
                jPanel.repaint();
            }
        });


        jPanelButton.add(modify);
        jPanelButton.add(delete);
        jPanelButton.add(department);

        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRowIndex != -1) {

                }
            }


        });


    }
    public void showTable() {
        String[] columnNames = {"ID", "Nom", "Prénom", "Rôle"};
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        List<Employee> employees = employeeController.displayAll();
        for (Employee employee : employees) {
            Object[] rowData = {employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getRole()};
            tableModel.addRow(rowData);
        }

         table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

    }
}
