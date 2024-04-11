package org.example.view;

import org.example.model.Qualification;
import org.example.service.EmployeeService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeUI  {

    private EmployeeService employeeService;
    private JFrame mainPanel;

    public EmployeeUI() {
        this.employeeService = new EmployeeService();
        initializeUI();



    }

    private void initializeUI() {
        mainPanel = new JFrame();
        mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setSize(1100, 800);
        mainPanel.setLocationRelativeTo(null);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setVisible(true);

        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        infoPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;
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
        JTextField employeeIdField = new JTextField(15);
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
        JLabel imagePath = new JLabel("ImagePath");
        infoPanel.add(imagePath, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        JTextField adressField = new JTextField(20);
        adressField.setPreferredSize(new Dimension(adressField.getPreferredSize().width, adressField.getPreferredSize().height * 5));
        infoPanel.add(adressField, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = adressField.getWidth();
        JButton upload = new JButton("Upload Image");

        infoPanel.add(upload, gbc);

















        mainPanel.add(infoPanel, BorderLayout.NORTH);
    }

}
