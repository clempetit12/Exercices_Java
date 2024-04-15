package org.example.view;

import org.example.model.Employee;
import org.example.model.Qualification;
import org.example.service.EmployeeService;
import org.example.utils.TableModelEmployee;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeUI {

    private EmployeeService employeeService;
    private JFrame mainPanel;

    private int selectedRow;

    boolean isGender;
    JTextField image;
    ImageIcon originalImageIcon;

    JTextField employeeIdField;

    JLabel imagePath;

    private Qualification selectedQualification;

    private JTable employeeTable;

    public EmployeeUI() {
        this.employeeService = new EmployeeService();
        initializeUI();


    }

    private void initializeUI() {
        mainPanel = new JFrame();
        mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setSize(1500, 600);
        mainPanel.setLocationRelativeTo(null);
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setVisible(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        //Panel formulaire
        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        infoPanel.setLayout(new GridBagLayout());
        infoPanel.setBorder(border);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel employeeIdLabel = new JLabel("EmployeeId");
        infoPanel.add(employeeIdLabel, gbc);

        gbc.gridy = 1;
        JLabel nameLabel = new JLabel("Name");
        infoPanel.add(nameLabel, gbc);

        gbc.gridy = 2;
        JLabel gender = new JLabel("Gender");
        infoPanel.add(gender, gbc);

        gbc.gridy = 3;
        JLabel age = new JLabel("Age");
        infoPanel.add(age, gbc);

        gbc.gridy = 4;
        JLabel bloddGroup = new JLabel("BloodGroup");
        infoPanel.add(bloddGroup, gbc);

        gbc.gridy = 5;
        JLabel contactNumber = new JLabel("ContactNumber");
        infoPanel.add(contactNumber, gbc);

        gbc.gridy = 6;
        JLabel qualification = new JLabel("Qualification");
        infoPanel.add(qualification, gbc);

        gbc.gridy = 7;
        JLabel startDate = new JLabel("StartDate");
        infoPanel.add(startDate, gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;
         employeeIdField = new JTextField(15);
        infoPanel.add(employeeIdField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField nameField = new JTextField(15);
        infoPanel.add(nameField, gbc);

        ButtonGroup radioButtonGroup = new ButtonGroup();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Femme");
        radioButtonGroup.add(male);
        radioButtonGroup.add(female);

        male.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isGender = male.isSelected();
            }
        });

        female.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isGender = !female.isSelected();
            }
        });
        GridBagConstraints gbcMale = new GridBagConstraints();
        gbcMale.gridx = 1;
        gbcMale.gridy = 2;
        gbcMale.anchor = GridBagConstraints.WEST;

        GridBagConstraints gbcFemale = new GridBagConstraints();
        gbcFemale.gridx = 1;
        gbcFemale.gridy = 2;
        gbcFemale.anchor = GridBagConstraints.EAST;

        infoPanel.add(male, gbcMale);

        infoPanel.add(female, gbcFemale);

        gbc.gridx = 1;
        gbc.gridy = 3;
        JTextField ageField = new JTextField(15);
        infoPanel.add(ageField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        JTextField bloodGroup = new JTextField(15);
        infoPanel.add(bloodGroup, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        JTextField contactField = new JTextField(15);
        infoPanel.add(contactField, gbc);


        gbc.gridx = 1;
        gbc.gridy = 6;
        EnumSet<Qualification> qualificationSet = EnumSet.allOf(Qualification.class);

        List<String> qualificationNames = qualificationSet.stream()
                .map(Enum::name)
                .collect(Collectors.toList());

        JComboBox<String> qualificationComboBox = new JComboBox<>(qualificationNames.toArray(new String[0]));
        qualificationComboBox.setPreferredSize(new Dimension(180, 30));

        qualificationComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedQualificationName = (String) qualificationComboBox.getSelectedItem();
                selectedQualification = Qualification.valueOf(selectedQualificationName);

            }
        });


        gbc.gridx = 1;
        gbc.gridy = 6;
        infoPanel.add(qualificationComboBox, gbc);


        gbc.gridx = 1;
        gbc.gridy = 7;
        JTextField startDateField = new JTextField(15);
        infoPanel.add(startDateField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        JLabel adress = new JLabel("Adress");
        infoPanel.add(adress, gbc);


        gbc.gridx = 2;
        gbc.gridy = 7;
        imagePath = new JLabel("ImagePath");
        infoPanel.add(imagePath, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        JTextField adressField = new JTextField(20);
        adressField.setPreferredSize(new Dimension(adressField.getPreferredSize().width, adressField.getPreferredSize().height * 5));
        infoPanel.add(adressField, gbc);

        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.gridwidth = adressField.getWidth();
        JButton upload = new JButton("Upload Image");

        infoPanel.add(upload, gbc);


        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 7;

        originalImageIcon = new ImageIcon("null");
        Image originalImage = originalImageIcon.getImage();

        Image scaledImage = originalImage.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledImageIcon);
        infoPanel.add(imageLabel, gbc);

        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon uploadedImageIcon = new ImageIcon(selectedFile.getPath());
                    Image originalImage = uploadedImageIcon.getImage();
                    Image scaledImage = originalImage.getScaledInstance(180, 300, Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                    imageLabel.setIcon(scaledImageIcon);
                    imagePath.setPreferredSize(new Dimension(200, 20));
                    image.setText(uploadedImageIcon.toString());
                }
            }
        });


        gbc.gridx = 3;
        gbc.gridy = 7;
        image = new JTextField(20);

        infoPanel.add(image, gbc);


        //Panel pour le crud

        JPanel crudPanel = new JPanel();
        crudPanel.setLayout(new FlowLayout());

        JLabel searchLabel = new JLabel("SEARCH");
        crudPanel.add(searchLabel);

        JTextField searchTxtField = new JTextField(15);
        crudPanel.add(searchTxtField);

        searchTxtField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("entree");
                String searchText = searchTxtField.getText().trim();
                Employee searchedEmployee = employeeService.searchEmployee(searchText);
                System.out.println(searchedEmployee);
                if (searchedEmployee != null) {
                    int employeeId = (int) employeeTable.getValueAt(selectedRow, 0);
                    employeeIdField.setText(String.valueOf(searchedEmployee.getEmployeeId()));
                    nameField.setText(searchedEmployee.getName());
                    ageField.setText(String.valueOf(searchedEmployee.getAge()));
                    bloodGroup.setText(searchedEmployee.getBloodGroup());
                    contactField.setText(searchedEmployee.getContactNumber());
                    startDateField.setText(String.valueOf(searchedEmployee.getStartDate()));
                    adressField.setText(searchedEmployee.getAddress());
                    image.setText(searchedEmployee.getUrlImage());
                    originalImageIcon = new ImageIcon(searchedEmployee.getUrlImage());
                    Image originalImage = originalImageIcon.getImage();
                    Image scaledImage = originalImage.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                    System.out.println(scaledImageIcon);
                    imageLabel.setIcon(scaledImageIcon);
                    imageLabel.revalidate();
                    imageLabel.repaint();
                    if (searchedEmployee.isGender()) {
                        male.setSelected(true);
                    } else {
                        female.setSelected(true);
                    }
                    qualificationComboBox.setSelectedItem(searchedEmployee.getQualification().name());

                    infoPanel.revalidate();
                    infoPanel.repaint();

                } else {
                    JOptionPane.showConfirmDialog(null, "Operation Failed");

                }
            }
        });


        JButton newButton = new JButton("New");
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/main/java/org/example/assets/icons8-new-48.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        newButton.setIcon(imageIcon);
        crudPanel.add(newButton);

        JButton saveButton = new JButton("Save");
        ImageIcon saveIcon = new ImageIcon(new ImageIcon("src/main/java/org/example/assets/icons8-sauvegarder-50.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        saveButton.setIcon(saveIcon);
        crudPanel.add(saveButton);


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();

                boolean gender = isGender;

                int age = Integer.parseInt(ageField.getText());

                String bloodGroupValue = bloodGroup.getText();

                String contact = contactField.getText();

                Qualification qualification1 = selectedQualification;
                System.out.println(qualification1);
                String dateString = startDateField.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate date = LocalDate.parse(dateString, formatter);

                String adress = adressField.getText();

                String imageValue = image.getText();

                Employee employee = new Employee(name, gender, age, bloodGroupValue, contact, qualification1, date, adress, imageValue);

                if (employeeService.createEmployee(employee)) {
                    JOptionPane.showConfirmDialog(null, "Operation succeed");
                    refreshTable();


                } else {
                    JOptionPane.showConfirmDialog(null, "Operation Failed");
                }


            }
        });


        JButton updateButton = new JButton("Update");
        ImageIcon updateIcon = new ImageIcon(new ImageIcon("src/main/java/org/example/assets/icons8-boucle-64.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        updateButton.setIcon(updateIcon);
        crudPanel.add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int employeeIdUpdate = Integer.parseInt(employeeIdField.getText());
                String name = nameField.getText();
                boolean gender = isGender;
                int age = Integer.parseInt(ageField.getText());
                String bloodGroupValue = bloodGroup.getText();
                String contact = contactField.getText();
                Qualification qualification1 = selectedQualification;
                String dateString = startDateField.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(dateString, formatter);
                String adress = adressField.getText();
                String imageValue = image.getText();
                Employee employee = new Employee(employeeIdUpdate,name, gender, age, bloodGroupValue, contact, qualification1, date, adress, imageValue);

                try {
                    if (employeeService.updateEmployee(employee)) {
                        JOptionPane.showConfirmDialog(null, "Operation succeed");
                        refreshTable();

                    } else {
                        JOptionPane.showConfirmDialog(null, "Operation Failed");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });


        JButton delete = new JButton("Delete");
        ImageIcon deleteIcon = new ImageIcon(new ImageIcon("src/main/java/org/example/assets/icons8-supprimer-30.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        delete.setIcon(deleteIcon);
        crudPanel.add(delete);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow >= 0) {
                    int employeeId = (int) employeeTable.getValueAt(selectedRow, 0);
                    employeeService.deleteEmploye(employeeId);
                    refreshTable();

                }
            }

            ;
        });


        JButton clear = new JButton("Clear");
        ImageIcon clearIcon = new ImageIcon(new ImageIcon("src/main/java/org/example/assets/icons8-symbole-effacer-50.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        clear.setIcon(clearIcon);
        crudPanel.add(clear);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeIdField.setText("");
                nameField.setText("");
                ageField.setText("");
                bloodGroup.setText("");
                contactField.setText("");
                startDateField.setText("");
                adressField.setText("");
                image.setText("");
                originalImageIcon = new ImageIcon();

            }


            ;
        });


        JButton print = new JButton("Print");
        ImageIcon printIcon = new ImageIcon(new ImageIcon("src/main/java/org/example/assets/icons8-impression-50.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        print.setIcon(printIcon);
        crudPanel.add(print);


        JPanel tablePanel = new JPanel(new BorderLayout());
        employeeTable = new JTable();
        refreshTable();
        tablePanel.add(new JScrollPane(employeeTable), BorderLayout.CENTER);


        mainPanel.add(infoPanel, BorderLayout.NORTH);


        mainPanel.add(tablePanel, BorderLayout.SOUTH);


        mainPanel.add(crudPanel, BorderLayout.CENTER);


        employeeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedRow = employeeTable.getSelectedRow();

                if (selectedRow >= 0) {
                    int employeeId = (int) employeeTable.getValueAt(selectedRow, 0);
                    Employee selectedEmployee = employeeService.getEmployee(employeeId);
                    employeeIdField.setText(String.valueOf(selectedEmployee.getEmployeeId()));
                    nameField.setText(selectedEmployee.getName());
                    ageField.setText(String.valueOf(selectedEmployee.getAge()));
                    bloodGroup.setText(selectedEmployee.getBloodGroup());
                    contactField.setText(selectedEmployee.getContactNumber());
                    startDateField.setText(String.valueOf(selectedEmployee.getStartDate()));
                    adressField.setText(selectedEmployee.getAddress());
                    image.setText(selectedEmployee.getUrlImage());
                    originalImageIcon = new ImageIcon(selectedEmployee.getUrlImage());
                    Image originalImage = originalImageIcon.getImage();
                    Image scaledImage = originalImage.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                    imageLabel.setIcon(scaledImageIcon);
                    if (selectedEmployee.isGender()) {
                        male.setSelected(true);
                    } else {
                        female.setSelected(true);
                    }
                    qualificationComboBox.setSelectedItem(selectedEmployee.getQualification().name());

                    infoPanel.revalidate();
                    infoPanel.repaint();

                }
            }
        });


    }

    private void refreshTable() {
        List<Employee> employees = employeeService.getAll();
        TableModelEmployee model = new TableModelEmployee((java.util.List<Employee>) employees);
        employeeTable.setModel(model);

    }

}
