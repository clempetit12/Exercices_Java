package org.example.component;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.User;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
public class Form {
    private JPanel panel;
    private JTextField inputName;
    private JTextField inputEmail;
    private JLabel title;
    private JLabel name;
    private JLabel email;
    private JLabel gendra;
    private JCheckBox man;
    private JCheckBox woman;
    private String selectedGendra;
    private ArrayList users = new ArrayList<>();
    private Table table;


    public Form(Table table) {
        this.table = table;
        initializePanel();
    }
    private void initializePanel() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 20));

        TitledBorder titledBorder = BorderFactory.createTitledBorder("Formulaire d'ajout");
        panel.setBorder(titledBorder);



        name = new JLabel("Nom:");
        inputName = new JTextField(20);

        email = new JLabel("Email:");
        inputEmail = new JTextField(20);


        gendra = new JLabel("Email:");
        man = new JCheckBox("Homme");
        woman = new JCheckBox("Femme");

        man.addActionListener(e -> {
            if (man.isSelected()) {
                selectedGendra = "Homme";
                woman.setSelected(false);
            }
        });

        woman.addActionListener(e -> {
            if (woman.isSelected()) {
                selectedGendra = "Femme";
                man.setSelected(false);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 90, 10));
        JButton button = new JButton("Ajouter");
        button.addActionListener(e -> addUser());
        button.setPreferredSize(new Dimension(100, 30));
        buttonPanel.add(button);

        Border roundedBorder = new LineBorder(Color.BLACK, 0, true);
        button.setBorder(roundedBorder);


        panel.add(name);
        panel.add(inputName);
        panel.add(email);
        panel.add(inputEmail);
        panel.add(gendra);
        panel.add(man);
        panel.add(woman);
        panel.add(buttonPanel);


    }

    private void addUser() {
        String name = inputName.getText();
        String email = inputEmail.getText();
        String gendra = selectedGendra;

        User user = new User(name, email,selectedGendra );
        users.add(user);
        table.addUser(user);

        System.out.println(users);

    }
}
